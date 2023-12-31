package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusRps {
    @XmlEnumValue("1")
    NORMAL('N'),

    @XmlEnumValue("2")
    CANCELADO('C');

    private final char codigo;

    @Override
    public String toString() { return String.valueOf(codigo); }

    public static StatusRps fromChar(char situacao) {
        if (situacao == StatusRps.CANCELADO.getCodigo()) {
            return StatusRps.CANCELADO;
        }

        return StatusRps.NORMAL;
    }
}
