package com.mauricio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SimNao {
    SIM(1, "Sim"),
    NAO(2, "Nao");

    private final int codigo;
    private final String descricao;

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
