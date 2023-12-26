package com.mauricio.domain.utils;

public class MessageUtils {
    // Mensagens  de sucesso
    public static final String S_LOTE_GERADO_ASSINADO = "Arquivo de lote RPS gerado e assinado com sucesso.";

    // Mensagens de erro
    public static final String E_TIPO_NRO_LOTE = "Número do lote precisa ser um valor inteiro válido.";
    public static final String E_FORMULARIO_INCOMPLETO = "Preencha todos os campos do formulário.";
    public static final String E_ARQUIVO_BAZEVANI = "Erro na leitura/estrutura do arquivo de texto gerado pelo Bazevani.";
    public static final String E_ASSINAR_ARQUIVO_LOTE = "Erro ao assinar arquivo de lote. Verifique se o cartão do certificado digital está conectado.";
    public static final String E_ESCREVER_ARQUIVO_ASSINADO = "Erro ao gerar arquivo de lote assinado.";
}
