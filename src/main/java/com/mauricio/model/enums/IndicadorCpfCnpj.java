package com.mauricio.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IndicadorCpfCnpj {
    CPF(1, "CPF"),
    CNPJ(2, "CNPJ"),
    SEM_CPF(3, "CPF nao informado");

    private final int codigo;
    private final String descricao;

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
