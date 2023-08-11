package com.mauricio.schemas;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcInfRps", propOrder = {
        "identificacaoRps",
        "dataEmissao",
        "status",
        "rpsSubstituido"
})
@Getter
@Setter
public class Rps {
    @XmlElement(name = "IdentificacaoRps", required = true)
    private IdentificacaoRps identificacaoRps;

    @XmlElement(name = "DataEmissao", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar dataEmissao;

    @XmlElement(name = "Status")
    private byte status;

    @XmlElement(name = "RpsSubstituido")
    private IdentificacaoRps rpsSubstituido;

    @XmlAttribute(name = "Id")
    private String id;

    @Override
    public String toString() {
        return "Rps{" +
                "identificacaoRps=" + identificacaoRps +
                ", dataEmissao=" + dataEmissao +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }
}
