package com.mauricio.domain.rpsSP;

import com.mauricio.domain.enums.IssRetido;
import com.mauricio.domain.rpsPontal.DadosTomador;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DadosServicoSp {
    private String codigoServico;
    private IssRetido issRetido; // todo criar enum
    private ValoresServico valoresServico;
    private CargaTributaria cargaTributaria;
    private DadosTomador dadosTomador;
    private String codMunicipioPrestacao;
    private String discriminacao; // algo errado aqui
    // CEI, codigo obra e numero de encapsulamento - nao sei o que fazer

    public static DadosServicoSp fromString(String line) {
        String codigoServico = line.substring(62, 67).trim();
        String codMunicipioPrestacao = line.substring(569, 576).trim();
        String discriminacao = line.substring(786-10).strip(); // TODO verificar erro no arquivo das linhas 596 a 776
        int issRetido = Integer.parseInt(line.substring(71, 72));

        CargaTributaria cargaTributaria = CargaTributaria.fromString(line);
        ValoresServico valoresServico = ValoresServico.fromString(line);
        DadosTomador dadosTomador = DadosTomador.fromString(line);

        DadosServicoSp dadosServico = new DadosServicoSp();
        dadosServico.setCodigoServico(codigoServico);
        dadosServico.setCodMunicipioPrestacao(codMunicipioPrestacao);
        dadosServico.setDiscriminacao(discriminacao);
        dadosServico.setCargaTributaria(cargaTributaria);
        dadosServico.setValoresServico(valoresServico);
        dadosServico.setDadosTomador(dadosTomador);

        if (issRetido == IssRetido.TOMADOR.getCodigo()) {
            dadosServico.setIssRetido(IssRetido.TOMADOR);
        } else if (issRetido == IssRetido.NAO_POSSUI.getCodigo()) {
            dadosServico.setIssRetido(IssRetido.NAO_POSSUI);
        } else if (issRetido == IssRetido.INTERMEDIARIO.getCodigo()) {
            dadosServico.setIssRetido(IssRetido.INTERMEDIARIO);
        }

        return dadosServico;
    }
}
