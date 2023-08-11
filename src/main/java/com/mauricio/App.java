package com.mauricio;

import com.mauricio.model.LoteRps;
import com.mauricio.schemas.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.*;

public class App {
    public static void main(String[] args) {
        CpfCnpj cpfCnpj = new CpfCnpj();
        cpfCnpj.setCnpj("01001001000113");

        LoteRps loteRps = new LoteRps();
        loteRps.setNumeroLote(BigInteger.ONE);
        loteRps.setCpfCnpj(cpfCnpj);
        loteRps.setInscricaoMunicipal("1.000.10");
        loteRps.setQuantidadeRps(1);

        IdentificacaoRps identificacaoRps = new IdentificacaoRps();
        identificacaoRps.setNumero(BigInteger.valueOf(5402));
        identificacaoRps.setSerie("UNICA");
        identificacaoRps.setTipo(Byte.parseByte("1"));

        Rps rps = new Rps();
        rps.setIdentificacaoRps(identificacaoRps);
        GregorianCalendar date = new GregorianCalendar(2013, Calendar.DECEMBER, 10);
        rps.setDataEmissao(retrieveXMLGregorianCalendar(date));
        rps.setStatus(Byte.parseByte("1"));
        rps.setId("optional");

        InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico = new InfDeclaracaoPrestacaoServico();
        infDeclaracaoPrestacaoServico.setRps(rps);
        infDeclaracaoPrestacaoServico.setCompetencia(retrieveXMLGregorianCalendar(date));
        infDeclaracaoPrestacaoServico.setId("rps5402UNICA");

        DeclaracaoPrestacaoServico declaracaoPrestacaoServico = new DeclaracaoPrestacaoServico();
        declaracaoPrestacaoServico.setInfDeclaracaoPrestacaoServico(infDeclaracaoPrestacaoServico);

        ListaRps listaRps = new ListaRps();
        listaRps.setRps(List.of(declaracaoPrestacaoServico));
        loteRps.setListaRps(listaRps);

        loteRps.setId("5402");
        loteRps.setVersao("2.01");

        jaxbObjectToXML(loteRps);
    }

    private static XMLGregorianCalendar retrieveXMLGregorianCalendar(GregorianCalendar date) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static void jaxbObjectToXML(LoteRps loteRps) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LoteRps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to Console
            jaxbMarshaller.marshal(loteRps, new File("src/main/resources/loteRps.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
