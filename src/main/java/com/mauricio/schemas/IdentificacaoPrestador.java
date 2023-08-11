package com.mauricio.schemas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoPrestador", propOrder = {
        "cpfCnpj",
        "inscricaoMunicipal"
})
@Getter
@Setter
public class IdentificacaoPrestador {
    @XmlElement(name = "CpfCnpj")
    protected CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    protected String inscricaoMunicipal;
}
