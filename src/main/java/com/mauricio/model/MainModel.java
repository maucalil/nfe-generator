package com.mauricio.model;

import com.mauricio.domain.assinatura.CertificadoDigital;
import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;

@Getter
@Setter
public class MainModel {
    private CertificadoDigital certificado;
    private Integer nroLote;
    private String arquivoLoteSp;
    private Enumeration<String> aliases;
}
