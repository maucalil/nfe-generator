package com.mauricio.domain.enums;

import jakarta.xml.bind.annotation.XmlEnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SimNao {
    @XmlEnumValue("1")
    SIM(1, "Sim"),

    @XmlEnumValue("2")
    NAO(2, "Nao");

    private final int codigo;
    private final String descricao;

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
