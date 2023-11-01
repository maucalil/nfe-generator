package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String bairro = line.substring(275, 305).strip();
        String uf = line.substring(355, 357);
        String cep = line.substring(357, 365);
        // codigoMunicipio - so tem o nome
        // codigo pais nao tem

        Pattern pattern = getEnderecoPattern();
        Matcher matcher = pattern.matcher(line.substring(185, 235));

        Endereco enderecoCompleto = new Endereco();
        if (matcher.find()) {
            enderecoCompleto.setEndereco(matcher.group(1));
            enderecoCompleto.setNumero(matcher.group(2));

            String complemento = matcher.group(3).strip();
            if (!complemento.isEmpty()) {
                enderecoCompleto.setComplemento(complemento);
            }
        }
        enderecoCompleto.setBairro(bairro);
        enderecoCompleto.setUf(uf);
        enderecoCompleto.setCep(cep);

        return enderecoCompleto;
    }

    // O endereco (endereco, numero e complemento) vem tudo junto na string do txt de SP
    // Este metodo visa retornar o Patter que reconhece o regex para separar os 3 componentes
    private static Pattern getEnderecoPattern()  {
        // Primeiro grupo eh o endereco, segundo o numero e terceiro o complemento
        String REGEX = "([\\w\\W]+)\\s(\\d+)\\s?([\\w\\W]+)";
        return Pattern.compile(REGEX);
    }
}
