package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponsavelRetencao {
    @XmlEnumValue("1")
    TOMADOR(1),

    @XmlEnumValue("2")
    INTERMEDIARIO(2);

    private final int codigo;
}
