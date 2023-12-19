package com.mauricio.domain.assinatura;

import lombok.AllArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mauricio.domain.utils.ConstantUtils.ELEMENTOS_ASSINAVEIS;
import static com.mauricio.domain.utils.ConstantUtils.INF_DECLARACAO_PRESTACAO_SERVICO;

@AllArgsConstructor
public class AssinaturaDigital {
    private CertificadoDigital certificado;

    public String assinarXML(String xml) throws Exception {
        AssinaturaContext assinaturaContext = criarAssinaturaContext();
        Document document = documentFactory(xml);

        // Assinando todos RPS
        NodeList elements = document.getElementsByTagName(INF_DECLARACAO_PRESTACAO_SERVICO);
        assinarElementos(elements, assinaturaContext);

        Document documentAssinado = documentFactory(converteDocParaXml(document));

        // Assinando o Lote de RPS
        for (final String elementoAssinavel : ELEMENTOS_ASSINAVEIS) {
            NodeList elementsAssinado =
                    documentAssinado.getDocumentElement().getElementsByTagName(elementoAssinavel);
            assinarElementos(elementsAssinado, assinaturaContext);
        }

        return converteDocParaXml(documentAssinado);
    }

    private AssinaturaContext criarAssinaturaContext()
            throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException, InvalidAlgorithmParameterException {
        String aliasCertificado = this.certificado.getAliasCertificado();
        KeyStore keyStoreCertificado = this.certificado.getKeyStoreCertificado();

        KeyStore.PasswordProtection passwordProtection =
                new KeyStore.PasswordProtection(this.certificado.getSenhaCertificado().toCharArray());
        KeyStore.PrivateKeyEntry pkEntry =
                (KeyStore.PrivateKeyEntry) keyStoreCertificado.getEntry(aliasCertificado, passwordProtection);

        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);

        X509Certificate cert = (X509Certificate) pkEntry.getCertificate();

        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<>();
        x509Content.add(cert);
        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

        return new AssinaturaContext(pkEntry, signatureFactory, transformList, keyInfo);
    }

    private ArrayList<Transform> signatureFactory(XMLSignatureFactory signatureFactory)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transformList = new ArrayList<>();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = signatureFactory.newTransform(Transform.ENVELOPED, tps);
        Transform c14NTransform =
                signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);
        return transformList;
    }

    private Document documentFactory(String xml)
            throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
        return document;
    }

    private void assinarElementos(NodeList elements, AssinaturaContext context) throws Exception {
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);

            String id = element.getAttribute("Id");
            element.setIdAttribute("Id", true);

            assinarElemento(context, element, "#" + id);
        }
    }

    private void assinarElemento(AssinaturaContext context, Element element, String referenceUri) throws Exception {
        Reference reference = context.getSignatureFactory().newReference(referenceUri,
                context.getSignatureFactory().newDigestMethod(DigestMethod.SHA1, null),
                context.getTransformList(), null, null);

        SignedInfo signedInfo = context.getSignatureFactory().newSignedInfo(
                context.getSignatureFactory().newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                        (C14NMethodParameterSpec) null),
                context.getSignatureFactory().newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                Collections.singletonList(reference));

        XMLSignature signature = context.getSignatureFactory().newXMLSignature(signedInfo, context.getKeyInfo());
        signature.sign(new DOMSignContext(context.getPkEntry().getPrivateKey(), element.getParentNode()));
    }

    private String converteDocParaXml(Document doc) throws TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Transformer trans = TransformerFactory.newInstance().newTransformer();

        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        trans.transform(new DOMSource(doc), new StreamResult(os));
        return os.toString();
    }
}
