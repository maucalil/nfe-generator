package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoRps {
    @XmlEnumValue("1")
    RPS("RPS"),

    @XmlEnumValue("2")
    MISTA("RPS-M"),

    @XmlEnumValue("3")
    CUPOM("Cupom");

    private final String codigo;

    @Override
    public String toString() {
        return codigo;
    }

    public static TipoRps fromString(String tipo) {
        if (tipo.equalsIgnoreCase(TipoRps.RPS.toString())) {
            return TipoRps.RPS;
        }

        if (tipo.equalsIgnoreCase(TipoRps.MISTA.toString())) {
            return TipoRps.MISTA;
        }

        return TipoRps.CUPOM;
    }
}
