package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoTomador", propOrder = {
        "cpfCnpj",
        "inscricaoMunicipal"
})
@Getter
@Setter
public class IdentificacaoTomador {
    @XmlElement(name = "CpfCnpj")
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;
}
