package com.mauricio.domain.utils;

import lombok.Getter;

@Getter
public class ConstantUtils {
    // Codigos IBGE
    public static final Integer CODIGO_PONTAL_IBGE = 3540200;
    public static final Integer CODIGO_SERTAOZINHO_IBGE = 3551702;
    public static final String CODIGO_PAIS_IBGE = "1058";

    // Dados RPS
    public  static final String CODIGO_LOCACAO_OU_VENDA = "10.05";
    public static final String CODIGO_AVALIACAO = "28.01";
    public static final String CNPJ_IMOBILIARIA = "44354456000125";
    public static final String INSCRICAO_MUNICIPAL = "1902";
    public static final String VERSAO_LOTE_RPS = "2.01";

    // Assinatura
    public static final String CERTIFICATE_ALIAS = "CLARA IMOVEIS LTDA";
    public static final String INF_DECLARACAO_PRESTACAO_SERVICO = "InfDeclaracaoPrestacaoServico";
    public static final String[] ELEMENTOS_ASSINAVEIS = new String[] {"LoteRps"};

    public static final String LOCBAZE_DIR_C = "C:/Bazevani/Locbaze/notas";
    public static final String LOCBAZE_DIR_B = "B:/Bazevani/Locbaze/notas";

    // Homologacao
//    public static final String CNPJ_IMOBILIARIA = "01001001000113";
//    public static final String INSCRICAO_MUNICIPAL = "15000";
}
