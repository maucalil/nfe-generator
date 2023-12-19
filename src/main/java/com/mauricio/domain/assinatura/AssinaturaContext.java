package com.mauricio.domain.assinatura;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.security.KeyStore;
import java.util.ArrayList;

// Classe para encapsular o contexto da assinatura
@AllArgsConstructor
@Getter
public class AssinaturaContext {
    private KeyStore.PrivateKeyEntry pkEntry;
    private XMLSignatureFactory signatureFactory;
    private ArrayList<Transform> transformList;
    private KeyInfo keyInfo;
}
