package com.mauricio;

import com.mauricio.domain.rpsPontal.EnviarLoteRps;
import com.mauricio.domain.rpsSP.LoteRpsSp;
import com.mauricio.domain.rpsPontal.LoteRps;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = App.class.getClassLoader();
        String filePath = null;
        try {
            filePath = Paths.get(classLoader.getResource("test_file.txt").toURI()).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        LoteRpsSp loteRpsSp = LoteRpsSp.fromTxtFile(filePath);
        for (RpsSp rps : loteRpsSp.getRpsList()) {
            System.out.println(rps);
        }

        LoteRps loteRps = LoteRps.fromLoteRpsSp(loteRpsSp);
        EnviarLoteRps enviarLoteRps = new EnviarLoteRps();
        enviarLoteRps.setLoteRps(loteRps);
        jaxbObjectToXML(enviarLoteRps);
    }

    private static void jaxbObjectToXML(EnviarLoteRps loteRps) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EnviarLoteRps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to Console
            jaxbMarshaller.marshal(loteRps, new File("src/main/resources/loteRpsTeste.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
