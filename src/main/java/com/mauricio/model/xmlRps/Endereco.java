package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

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
}
