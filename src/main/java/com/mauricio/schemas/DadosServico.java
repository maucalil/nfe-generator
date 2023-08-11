package com.mauricio.schemas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDadosServico", propOrder = {
        "valores",
        "issRetido",
        "responsavelRetencao",
        "itemListaServico",
        "codigoCnae",
        "codigoTributacaoMunicipio",
        "discriminacao",
        "codigoMunicipio",
        "codigoPais",
        "exigibilidadeISS",
        "municipioIncidencia",
        "numeroProcesso"
})
public class DadosServico {

}
