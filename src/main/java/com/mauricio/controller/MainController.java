package com.mauricio.controller;

import com.mauricio.domain.assinatura.CertificadoDigital;
import com.mauricio.domain.rpsPontal.EnviarLoteRps;
import com.mauricio.domain.rpsPontal.LoteRps;
import com.mauricio.domain.rpsSP.LoteRpsSp;
import com.mauricio.model.MainModel;
import com.mauricio.view.MainView;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
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

        mainView.getFileChooser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser();
            }
        });

        mainView.getBtnGerarLote().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performGerarLoteAction();
            }
        });

        fillCertificadoChooser();
    }

    private void showFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showDialog(null, null);

        mainModel.setArquivoLoteSp(fileChooser.getSelectedFile().getAbsolutePath());
        mainView.getFileChooserLabel().setText(fileChooser.getSelectedFile().getName());
    }

    private void performGerarLoteAction() {
        // Atualiza o modelo com os dados do formulário
        updateModel();

        // Converte o arquivo txt de SP em um Lote RPS
        LoteRpsSp loteRpsSp = getLoteRpsSp(mainModel.getArquivoLoteSp());
        LoteRps loteRps = LoteRps.fromLoteRpsSp(loteRpsSp);

        // Cria o arquivo XML do Lote RPS
        EnviarLoteRps enviarLoteRps = new EnviarLoteRps();
        enviarLoteRps.setLoteRps(loteRps);
        convertLoteRpsToXml(enviarLoteRps);

        // Assina o arquivo XML

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
        Enumeration<String> aliases = null;
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
        int nroLote = Integer.parseInt(mainView.getNroLote().getText());
        String pathArquivo = "src/main/resources/txtFiles/test.txt";

        mainModel.setCertificado(new CertificadoDigital(selectedCert, ks, certPassword));
        mainModel.setNroLote(nroLote);
        mainModel.setArquivoLoteSp(pathArquivo);
    }
    private LoteRpsSp getLoteRpsSp(String filePath) {
        LoteRpsSp loteRpsSp = null;
        try {
            loteRpsSp = LoteRpsSp.fromTxtFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return loteRpsSp;
    }

    private void convertLoteRpsToXml(EnviarLoteRps loteRps) {
        StringWriter stringWriter = new StringWriter();
        BigInteger nroLote = loteRps.getLoteRps().getNumeroLote();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EnviarLoteRps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(loteRps, new File("src/main/resources/LoteRps_" + nroLote + ".xml"));
//            jaxbMarshaller.marshal(loteRps, stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // Add more controller methods as needed
}
