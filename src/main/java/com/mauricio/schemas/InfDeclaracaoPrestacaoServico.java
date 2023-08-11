package com.mauricio.schemas;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcInfDeclaracaoPrestacaoServico", propOrder = {
        "rps",
        "competencia",
        "servico",
        "prestador",
        "tomador",
//        "intermediario",
//        "construcaoCivil",
        "regimeEspecialTributacao",
        "optanteSimplesNacional",
        "incentivoFiscal"
})
@Getter
@Setter
public class InfDeclaracaoPrestacaoServico {
    @XmlElement(name = "Rps")
    private Rps rps; // InfRps talvez

    @XmlElement(name = "Competencia", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar competencia;

    @XmlElement(name = "Servico", required = true)
    private String servico; // TODO: change to DadosServico

    @XmlElement(name = "Prestador", required = true)
    private IdentificacaoPrestador prestador; // TODO: change to IdentificacaoPrestador

    @XmlElement(name = "Tomador")
    private String tomador; // TODO: change to DadosTomador

//    @XmlElement(name = "Intermediario")
//    private String intermediario; // TODO: change to DadosIntermediario

//    @XmlElement(name = "ConstrucaoCivil")
//    private String construcaoCivil; // TODO: change to DadosConstrucaoCivil

    @XmlElement(name = "RegimeEspecialTributacao")
    private Byte regimeEspecialTributacao;

    @XmlElement(name = "OptanteSimplesNacional")
    private byte optanteSimplesNacional;

    @XmlElement(name = "IncentivoFiscal")
    private byte incentivoFiscal;

    @XmlAttribute(name = "Id")
    private String id;
}
