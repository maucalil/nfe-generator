package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDadosTomador", propOrder = {
        "identificacaoTomador",
        "razaoSocial",
        "endereco",
        "contato"
})
public class DadosTomador {
    @XmlElement(name = "IdentificacaoTomador")
    private IdentificacaoTomador identificacaoTomador;

    @XmlElement(name = "RazaoSocial")
    private String razaoSocial;

    @XmlElement(name = "Endereco")
    private Endereco endereco;

    @XmlElement(name = "Contato")
    private Contato contato;
}
