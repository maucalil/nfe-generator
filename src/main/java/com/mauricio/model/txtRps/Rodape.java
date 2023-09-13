package com.mauricio.model.txtRps;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rodape {
    private int qntLinhaDetalhes;
    private String valorTotalServicos; // no arquivo
    private String valorTotalDeducoes;

    public static Rodape fromString(String line) {
        String qntLinhaDetalhes = line.substring(1, 8).trim();
        String valorTotalServicos = line.substring(8, 23).trim();
        String valorTotalDeducoes = line.substring(23, 38).trim();

        Rodape rodape = new Rodape();
        rodape.setQntLinhaDetalhes(Integer.parseInt(qntLinhaDetalhes));
        rodape.setValorTotalServicos(valorTotalServicos);
        rodape.setValorTotalDeducoes(valorTotalDeducoes);

        return  rodape;
    }
}
