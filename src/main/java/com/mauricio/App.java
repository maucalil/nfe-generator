package com.mauricio;

import com.mauricio.model.MainModel;
import com.mauricio.view.MainView;
import com.mauricio.controller.MainController;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        CertificadoDigital certificado = new CertificadoDigital(CERTIFICATE_ALIAS, carregarCertificados(),"Obrigada1");
//        AssinaturaDigital assinaturaDigital = new AssinaturaDigital(certificado);
//        String result;
//        try {
//            String xmlPath = "src/main/resources/xmlFiles/loteRpsFake.xml";
//            result = assinaturaDigital.assinarXML(readXMLFile(xmlPath));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        String outputPath = "src/main/resources/xmlFiles/loteRpsFakeAss.xml";
//        try (PrintWriter writer = new PrintWriter(outputPath)) {
//            writer.println(result);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Erro ao escrever o arquivo: " + outputPath, e);
//        }
        SwingUtilities.invokeLater(() -> {
            MainModel mainModel = new MainModel();

            MainView.initLaF();
            MainView mainView = new MainView();

            MainController mainController = new MainController(mainView, mainModel);

            mainView.setVisible(true);
        });
    }
}
