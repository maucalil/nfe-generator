package com.mauricio.domain.rpsPontal;

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
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    public IdentificacaoPrestador() {
        CpfCnpj cpfCnpj = new CpfCnpj();
        cpfCnpj.setCnpj("00000000000");

        this.cpfCnpj = cpfCnpj;
        this.inscricaoMunicipal = "1902";
    }
}
