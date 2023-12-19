package com.mauricio.domain.rpsSP;

import com.mauricio.domain.enums.TipoRps;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class RpsSp {
    private TipoRps tipo;
    private String serie;
    private BigInteger numero;
    private String dataEmissao; // AAAAMMDD
    private char situacao;
    private DadosServicoSp dadosServico;

    public static RpsSp fromString(String line) {
        String serie = line.substring(6, 11).trim();
        String numero = line.substring(11, 23).trim();
        String dataEmissao = line.substring(23, 31).trim();
        char situacao = line.charAt(31);
        TipoRps tipo = TipoRps.fromString(line.substring(1, 6).trim());
        DadosServicoSp dadosServico = DadosServicoSp.fromString(line);

        RpsSp rps = new RpsSp();
        rps.setTipo(tipo);
        rps.setSerie(serie);
        rps.setNumero(new BigInteger(numero));
        rps.setDataEmissao(dataEmissao);
        rps.setSituacao(situacao);
        rps.setDadosServico(dadosServico);

        return rps;
    }
}
