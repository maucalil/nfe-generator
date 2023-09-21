package com.mauricio.model.txtRps;

import com.mauricio.model.xmlRps.DadosTomador;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DadosServicoTxt {
    private String codigoServico;
    private char issRetido; // todo criar enum
    private ValoresServico valoresServico;
    private CargaTributaria cargaTributaria;
    private DadosTomador dadosTomador;
    private String codMunicipioPrestacao;
    private String discriminacao; // algo errado aqui
    // CEI, codigo obra e numero de encapsulamento - nao sei o que fazer

    public static DadosServicoTxt fromString(String line) {
        String codigoServico = line.substring(62, 67).trim();
        String codMunicipioPrestacao = line.substring(569, 576).trim();
        String discriminacao = line.substring(786-10).strip(); // TODO verificar erro no arquivo das linhas 596 a 776
        char issRetido = line.charAt(71);

        CargaTributaria cargaTributaria = CargaTributaria.fromString(line);
        ValoresServico valoresServico = ValoresServico.fromString(line);
        DadosTomador dadosTomador = DadosTomador.fromString(line);

        DadosServicoTxt dadosServico = new DadosServicoTxt();
        dadosServico.setCodigoServico(codigoServico);
        dadosServico.setCodMunicipioPrestacao(codMunicipioPrestacao);
        dadosServico.setDiscriminacao(discriminacao);
        dadosServico.setIssRetido(issRetido);
        dadosServico.setCargaTributaria(cargaTributaria);
        dadosServico.setValoresServico(valoresServico);
        dadosServico.setDadosTomador(dadosTomador);

        return dadosServico;
    }
}
