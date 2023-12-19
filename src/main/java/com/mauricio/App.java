package com.mauricio;

import com.mauricio.domain.assinatura.AssinaturaDigital;
import com.mauricio.domain.assinatura.CertificadoDigital;
import com.mauricio.domain.rpsPontal.EnviarLoteRps;
import com.mauricio.domain.rpsSP.LoteRpsSp;
import com.mauricio.domain.rpsPontal.LoteRps;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import static com.mauricio.domain.utils.ConstantUtils.CERTIFICATE_ALIAS;

public class App {
    public static void main(String[] args) throws IOException {
//        ClassLoader classLoader = App.class.getClassLoader();
//        String filePath = null;
//        try {
//            filePath = Paths.get(classLoader.getResource("txtFiles/test.txt").toURI()).toString();
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//        LoteRpsSp loteRpsSp = LoteRpsSp.fromTxtFile(filePath);
//        for (RpsSp rps : loteRpsSp.getRpsList()) {
//            System.out.println(rps);
//        }
//
//        LoteRps loteRps = LoteRps.fromLoteRpsSp(loteRpsSp);
//        EnviarLoteRps enviarLoteRps = new EnviarLoteRps();
//        enviarLoteRps.setLoteRps(loteRps);
//        jaxbObjectToXML(enviarLoteRps);

        CertificadoDigital certificado = new CertificadoDigital(CERTIFICATE_ALIAS, carregarCertificados(),"Obrigada1");
        AssinaturaDigital assinaturaDigital = new AssinaturaDigital(certificado);
        String result;
        try {
            String xmlPath = "src/main/resources/xmlFiles/loteRpsFake.xml";
            result = assinaturaDigital.assinarXML(readXMLFile(xmlPath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String outputPath = "src/main/resources/xmlFiles/loteRpsFakeAss.xml";
        try (PrintWriter writer = new PrintWriter(outputPath)) {
            writer.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro ao escrever o arquivo: " + outputPath, e);
        }
    }

    private static KeyStore carregarCertificados() {
        KeyStore ks;
        try {
            ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            ks.load(null, null);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException |
                 NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        return ks;
    }

    private static void jaxbObjectToXML(EnviarLoteRps loteRps) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EnviarLoteRps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(loteRps, new File("src/main/resources/loteRpsFake.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String readXMLFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
