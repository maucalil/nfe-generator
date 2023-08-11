package com.mauricio.model;

import com.mauricio.schemas.CpfCnpj;
import com.mauricio.schemas.ListaRps;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;

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
public class LoteRps {
    @XmlElement(name = "NumeroLote", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numeroLote;

    @XmlElement(name = "CpfCnpj", required = true)
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    @XmlElement(name = "QuantidadeRps")
    private int quantidadeRps;

    @XmlElement(name = "ListaRps", required = true)
    private ListaRps listaRps;

    @XmlAttribute(name = "Id")
    private String id;

    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String versao;

    @Override
    public String toString() {
        return "LoteRps{" +
                "numeroLote=" + numeroLote +
                ", cpfCnpj=" + cpfCnpj.getCnpj() +
                ", inscricaoMunicipal='" + inscricaoMunicipal + '\'' +
                ", quantidadeRps=" + quantidadeRps +
                ", listaRps=" + listaRps +
                ", id='" + id + '\'' +
                ", versao='" + versao + '\'' +
                '}';
    }

    public static LoteRps fromTxtFile(String filePath) {
        throw new UnsupportedOperationException("Unimplemented");
    }
}
