package com.mauricio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoRegistro {
    CABECALHO(1, "Cabecalho"),
    DETALHE(6, "Detalhe"),
    RODAPE(9, "Rodape");

    private final int codigo;
    private final String descricao;

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
