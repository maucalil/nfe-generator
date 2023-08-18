package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcValoresDeclaracaoServico", propOrder = {
        "valorServicos",
        "valorDeducoes",
        "valorPis",
        "valorCofins",
        "valorInss",
        "valorIr",
        "valorCsll",
        "outrasRetencoes",
        "valorIss",
        "aliquota",
        "descontoIncondicionado",
        "descontoCondicionado"
})
@Getter
@Setter
public class ValoresDeclaracaoServico {
    @XmlElement(name = "ValorServicos", required = true)
    private BigDecimal valorServicos;

    @XmlElement(name = "ValorDeducoes")
    private BigDecimal valorDeducoes;

    @XmlElement(name = "ValorPis")
    private BigDecimal valorPis;

    @XmlElement(name = "ValorCofins")
    private BigDecimal valorCofins;

    @XmlElement(name = "ValorInss")
    private BigDecimal valorInss;

    @XmlElement(name = "ValorIr")
    private BigDecimal valorIr;

    @XmlElement(name = "ValorCsll")
    private BigDecimal valorCsll;

    @XmlElement(name = "OutrasRetencoes")
    private BigDecimal outrasRetencoes;

    @XmlElement(name = "ValorIss")
    private BigDecimal valorIss;

    @XmlElement(name = "Aliquota")
    private BigDecimal aliquota;

    @XmlElement(name = "DescontoIncondicionado")
    private BigDecimal descontoIncondicionado;

    @XmlElement(name = "DescontoCondicionado")
    private BigDecimal descontoCondicionado;
}
