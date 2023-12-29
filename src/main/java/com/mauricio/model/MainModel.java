package com.mauricio.model;

import com.mauricio.domain.assinatura.CertificadoDigital;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Enumeration;

@Getter
@Setter
public class MainModel {
    private CertificadoDigital certificado;
    private BigInteger nroLote;
    private String arquivoLoteSp;
    private Boolean comAssinatura;
    private Enumeration<String> aliases;
}
