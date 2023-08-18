package com.mauricio.model.txtRps;

public class Cabecalho { // talvez não façã sentido, só preciso da inscricaoMunicipal
    private Byte tipoRegistro; // Always 1
    private String versaoArquivo; // Always 002
    private String inscricaoMunicipalPrestador;
    private String dataInicio;
    private String dataFim;
}
