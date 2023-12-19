package com.mauricio.domain.assinatura;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.security.KeyStore;

@AllArgsConstructor
@Getter
public class CertificadoDigital {
    private String aliasCertificado;
    private KeyStore keyStoreCertificado;
    private String senhaCertificado;
}
