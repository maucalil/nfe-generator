package com.mauricio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IssRetido {
    TOMADOR(1, "ISS retido pelo tomador"),
    NAO_POSSUI(2, "Nota fiscal sem ISS retido"),
    INTERMEDIARIO(3, "ISS retido pelo intermediario");

    private final int codigo;
    private final String descricao;

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
