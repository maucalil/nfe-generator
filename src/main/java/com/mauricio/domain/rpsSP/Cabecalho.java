package com.mauricio.domain.rpsSP;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cabecalho { // talvez não façã sentido, só preciso da inscricaoMunicipal
//    private Byte tipoRegistro; // Always 1
    private String versaoArquivo; // Always 002
    private String inscricaoMunicipalPrestador;
    private String dataInicio;
    private String dataFim;

    public static Cabecalho fromString(String line) {
        String versao = line.substring(1, 4).trim();
        String inscricaoMunicipalPrestador = line.substring(4, 12).trim();
        String dataInicio = line.substring(12, 20).trim();
        String dataFim = line.substring(20).trim();

        Cabecalho cabecalho = new Cabecalho();
        cabecalho.setVersaoArquivo(versao);
        cabecalho.setInscricaoMunicipalPrestador(inscricaoMunicipalPrestador);
        cabecalho.setDataInicio(dataInicio);
        cabecalho.setDataFim(dataFim);

        return  cabecalho;
    }
}
