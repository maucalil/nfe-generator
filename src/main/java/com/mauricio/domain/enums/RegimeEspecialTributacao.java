package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RegimeEspecialTributacao {
    @XmlEnumValue("1")
    MICROEMPRESA_MUNICIPAL(1, "Microempresa Municipal"),
    @XmlEnumValue("2")
    ESTIMATIVA(2, "Estimativa"),
    @XmlEnumValue("3")
    SOCIEDADE_DE_PROFISSIONAIS(3, "Sociedade de Profissionais"),
    @XmlEnumValue("4")
    COOPERATIVA(4, "Cooperativa"),
    @XmlEnumValue("5")
    MEI(5, "Microempresário Individual (MEI)"),
    @XmlEnumValue("6")
    ME_EPP(6, "Microempresário e Empresa de Pequeno Porte (ME EPP)");

    private final int codigo;
    private final String descricao;
}
