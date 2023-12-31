package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDeclaracaoPrestacaoServico", propOrder = {
        "infDeclaracaoPrestacaoServico",
        "signature"
})
@Getter
@Setter
@ToString
public class DeclaracaoPrestacaoServico {
    @XmlElement(name = "InfDeclaracaoPrestacaoServico", required = true)
    private InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico;

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    private String signature;

    public static DeclaracaoPrestacaoServico fromSpModel(RpsSp rpsSp) {
        InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico = InfDeclaracaoPrestacaoServico.fromSpModel(rpsSp);

        DeclaracaoPrestacaoServico declaracaoPrestacaoServico = new DeclaracaoPrestacaoServico();
        declaracaoPrestacaoServico.setInfDeclaracaoPrestacaoServico(infDeclaracaoPrestacaoServico);

        return declaracaoPrestacaoServico;
    }
}
