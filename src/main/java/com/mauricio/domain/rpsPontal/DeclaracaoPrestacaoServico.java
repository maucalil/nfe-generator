package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDeclaracaoPrestacaoServico", propOrder = {
        "infDeclaracaoPrestacaoServico",
        "signature"
})
@Getter
@Setter
public class DeclaracaoPrestacaoServico {
    @XmlElement(name = "InfDeclaracaoPrestacaoServico", required = true)
    private InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico;

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    private String signature; // TODO: change to SignatureType
}
