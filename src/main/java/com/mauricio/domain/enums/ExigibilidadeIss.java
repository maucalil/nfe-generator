package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExigibilidadeIss {
    @XmlEnumValue("1")
    EXIGIVEL(1),

    @XmlEnumValue("2")
    NAO_INCIDENCIA(2),
    @XmlEnumValue("3")
    ISENCAO(3),

    @XmlEnumValue("4")
    EXPORTACAO(4),

    @XmlEnumValue("5")
    IMUNIDADE(5),

    @XmlEnumValue("6")
    SUSPENSA_POR_DECISAO_JUDICIAL(6),

    @XmlEnumValue("7")
    SUSPENSA_POR_PROCESSO_ADMINISTRATIVO(7);

    private final int codigo;
}
