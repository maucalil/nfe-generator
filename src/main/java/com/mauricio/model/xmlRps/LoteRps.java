package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@XmlRootElement(name = "LoteRps")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcLoteRps", propOrder = {
        "numeroLote",
        "cpfCnpj",
        "inscricaoMunicipal",
        "quantidadeRps",
        "listaRps"
})
@Getter
@Setter
@ToString
public class LoteRps {
    @XmlElement(name = "NumeroLote", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numeroLote;

    @XmlElement(name = "CpfCnpj", required = true)
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal; // do prestador

    @XmlElement(name = "QuantidadeRps")
    private int quantidadeRps;

    @XmlElement(name = "ListaRps", required = true)
    private ListaRps listaRps;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String versao;
}