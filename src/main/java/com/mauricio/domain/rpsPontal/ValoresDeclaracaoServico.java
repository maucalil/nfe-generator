package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.converters.StringConverter;
import com.mauricio.domain.rpsSP.ValoresServico;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
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
    private BigDecimal outrasRetencoes; // TODO remover?

    @XmlElement(name = "ValorIss")
    private BigDecimal valorIss;

    @XmlElement(name = "Aliquota")
    private BigDecimal aliquota;

    @XmlElement(name = "DescontoIncondicionado")
    private BigDecimal descontoIncondicionado; // TODO remover?

    @XmlElement(name = "DescontoCondicionado")
    private BigDecimal descontoCondicionado; // TODO remover?

    public static ValoresDeclaracaoServico fromSpModel(ValoresServico valoresServico) {

        BigDecimal valorServicos = StringConverter.toBigDecimal(valoresServico.getValorServicos());
        BigDecimal valorDeducoes = StringConverter.toBigDecimal(valoresServico.getValorDeducoes());
        BigDecimal valorPis = StringConverter.toBigDecimal(valoresServico.getValorPis());
        BigDecimal valorCofins = StringConverter.toBigDecimal(valoresServico.getValorCofins());
        BigDecimal valorInss = StringConverter.toBigDecimal(valoresServico.getValorInss());
        BigDecimal valorIr = StringConverter.toBigDecimal(valoresServico.getValorIr());
        BigDecimal valorCsll = StringConverter.toBigDecimal(valoresServico.getValorCsll());
        BigDecimal aliquota = StringConverter.toBigDecimal(valoresServico.getAliquota(), 4);

        ValoresDeclaracaoServico valores = new ValoresDeclaracaoServico();
        valores.setValorServicos(valorServicos);
        valores.setValorDeducoes(valorDeducoes);
        valores.setValorPis(valorPis);
        valores.setValorCofins(valorCofins);
        valores.setValorInss(valorInss);
        valores.setValorIr(valorIr);
        valores.setValorCsll(valorCsll);
        valores.setAliquota(aliquota);

        return valores;
    }

}
