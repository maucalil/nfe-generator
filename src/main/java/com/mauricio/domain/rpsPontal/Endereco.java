package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcEndereco", propOrder = {
        "endereco",
        "numero",
        "complemento",
        "bairro",
        "codigoMunicipio",
        "uf",
        "codigoPais",
        "cep"
})
@Getter
@Setter
@ToString
public class Endereco {
    @XmlElement(name = "Endereco")
    private String endereco;

    @XmlElement(name = "Numero")
    private String numero;

    @XmlElement(name = "Complemento")
    private String complemento;

    @XmlElement(name = "Bairro")
    private String bairro;

    @XmlElement(name = "CodigoMunicipio")
    private Integer codigoMunicipio;

    @XmlElement(name = "Uf")
    private String uf;

    @XmlElement(name = "CodigoPais")
    private String codigoPais;

    @XmlElement(name = "Cep")
    private String cep;

    public static Endereco fromString(String line) {
        String endereco = line.substring(185, 235).strip();
        // numero e complemento estao no de cima, o que fazer?
        String bairro = line.substring(275, 305).strip();
        // codigoMunicipio - so tem o nome
        String uf = line.substring(355, 357);
        String cep = line.substring(357, 365);
        // codigo pais nao tem

        Endereco enderecoCompleto = new Endereco();
        enderecoCompleto.setEndereco(endereco);
        enderecoCompleto.setBairro(bairro);
        enderecoCompleto.setBairro(bairro);
        enderecoCompleto.setUf(uf);
        enderecoCompleto.setCep(cep);

        return enderecoCompleto;
    }
}
