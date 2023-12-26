package com.mauricio.controller;

import com.mauricio.domain.assinatura.AssinaturaDigital;
import com.mauricio.domain.assinatura.CertificadoDigital;
import com.mauricio.domain.rpsPontal.EnviarLoteRps;
import com.mauricio.domain.rpsPontal.LoteRps;
import com.mauricio.domain.rpsSP.LoteRpsSp;
import com.mauricio.domain.utils.MessageUtils;
import com.mauricio.model.MainModel;
import com.mauricio.view.MainView;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class MainController {
    private final MainView mainView;
    private final MainModel mainModel;
    private KeyStore ks;

    public MainController(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;

        mainView.getFileChooserBtn().addActionListener(e -> showFileChooser());

        mainView.getBtnGerarLote().addActionListener(e -> performGerarLoteAction());

        fillCertificadoChooser();
    }

    private void showFileChooser() {
        JFileChooser fileChooser = mainView.getFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showDialog(null, null);

        File fileChosen = fileChooser.getSelectedFile();
        if (fileChosen != null) {
            mainView.getFileChooserLabel().setText(fileChosen.getName());
        }
    }

    private void performGerarLoteAction() {
        mainView.getBtnGerarLote().setEnabled(false);

        try {
            // Atualiza o modelo com os dados do formulário
            updateModel();

            // Converte o arquivo txt de SP em um Lote RPS xml
            LoteRps loteRps = getLoteRps();
            String xmlFile = convertLoteRpsToXml(loteRps);

            // Assina o arquivo XML
            signLoteRps(xmlFile);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(mainView, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(mainView, MessageUtils.E_ESCREVER_ARQUIVO_ASSINADO, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException | JAXBException e) {
            JOptionPane.showMessageDialog(mainView, MessageUtils.E_ARQUIVO_BAZEVANI, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainView, MessageUtils.E_ASSINAR_ARQUIVO_LOTE, "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            mainView.getBtnGerarLote().setEnabled(true);
        }

        JOptionPane.showMessageDialog(mainView, MessageUtils.S_LOTE_GERADO_ASSINADO, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private Enumeration<String> loadCertificados() throws KeyStoreException {
        try {
            ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            ks.load(null, null);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException |
                 NoSuchProviderException e) {
            throw new RuntimeException(e);
        }

        return ks.aliases();
    }
    private void fillCertificadoChooser() {
        Enumeration<String> aliases;
        try {
            aliases = loadCertificados();
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            mainView.getCertificadoChooser().addItem(alias);
        }
    }

    private void updateModel() {
        String selectedCert = (String) mainView.getCertificadoChooser().getSelectedItem();
        String certPassword = new String(mainView.getCertificadoPassword().getPassword());
        String nroLoteInput = mainView.getNroLote().getText().trim();
        File arquivoLoteSp = mainView.getFileChooser().getSelectedFile();

        if (selectedCert == null || certPassword.isEmpty() || nroLoteInput.isEmpty() || arquivoLoteSp == null) {
            throw new IllegalArgumentException(MessageUtils.E_FORMULARIO_INCOMPLETO);
        }

        try {
            mainModel.setCertificado(new CertificadoDigital(selectedCert, ks, certPassword));
            mainModel.setNroLote(new BigInteger(nroLoteInput));
            mainModel.setArquivoLoteSp(arquivoLoteSp.getAbsolutePath());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageUtils.E_TIPO_NRO_LOTE);
        }
    }

    private LoteRps getLoteRps() throws IOException {
        // Converte o arquivo txt de SP em um Lote RPS xml
        LoteRpsSp loteRpsSp = LoteRpsSp.fromTxtFile(mainModel.getArquivoLoteSp());
        LoteRps loteRps = LoteRps.fromLoteRpsSp(loteRpsSp);
        loteRps.setNumeroLote(mainModel.getNroLote());
        return loteRps;
    }

    private String convertLoteRpsToXml(LoteRps loteRps) throws JAXBException {
        // Cria o arquivo XML do Lote RPS
        EnviarLoteRps enviarLoteRps = new EnviarLoteRps();
        enviarLoteRps.setLoteRps(loteRps);

        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(EnviarLoteRps.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal(enviarLoteRps, stringWriter);

        return stringWriter.toString();
    }

    private void signLoteRps(String xmlFile) throws Exception {
        // Assina o XML com o certificado digital
        CertificadoDigital certificado = mainModel.getCertificado();
        AssinaturaDigital assinaturaDigital = new AssinaturaDigital(certificado);
        String result = assinaturaDigital.assinarXML(xmlFile);


        String outputPath = "Lote_" + mainModel.getNroLote() + ".xml";
        try (PrintWriter writer = new PrintWriter(outputPath)) {
            writer.println(result);
        }
    }
}
