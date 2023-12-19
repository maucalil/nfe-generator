package com.mauricio.domain.rpsSP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CargaTributaria {
    private String valor;
    private String porcentagem;
    private String fonte;

    public static CargaTributaria fromString(String line) {
        String valor = line.substring(515, 530).trim();
        String porcentagem = line.substring(530, 535).trim();
        String fonte = line.substring(535, 545).trim(); // TODO - check what to do when its all blank

        return new CargaTributaria(valor, porcentagem, fonte);
    }
}
