package com.mauricio.domain.rpsSP;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ValoresServico {
    // TODO: criar classe Valor que será igual string, mas conterá o método to bigDecimal
    // Valor é sempre de 15 digitos, onde os 2 ultimos digitos é a parte decimal do numero
    private String valorServicos;
    private String valorDeducoes;
    private String aliquota;
    private String valorPis;
    private String valorCofins;
    private String valorInss;
    private String valorIr;
    private String valorCsll;
    private String valorTotalRecebido;

    public static ValoresServico fromString(String line) {
        String valorServicos = line.substring(32, 47);
        String valorDeducoes = line.substring(47, 62);
        String aliquota = line.substring(67, 71);
        String valorPis = line.substring(440, 455);
        String valorCofins = line.substring(455, 470);
        String valorInss = line.substring(470, 485);
        String valorIr = line.substring(485, 500);
        String valorCsll = line.substring(500, 515);
        // Todo verificar porque nao esta sendo preenchido com zeros, erro no arquivo da coluna 596 a 776
//        String valorTotalRecebido = line.substring(596, 611);

        ValoresServico valoresServico = new ValoresServico();
        valoresServico.setValorServicos(valorServicos);
        valoresServico.setValorDeducoes(valorDeducoes);
        valoresServico.setAliquota(aliquota);
        valoresServico.setValorPis(valorPis);
        valoresServico.setValorCofins(valorCofins);
        valoresServico.setValorInss(valorInss);
        valoresServico.setValorIr(valorIr);
        valoresServico.setValorCsll(valorCsll);
//        valoresServico.setValorTotalRecebido(valorTotalRecebido);

        return valoresServico;
    }
}
