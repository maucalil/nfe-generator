package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoTomador", propOrder = {
        "cpfCnpj",
        "inscricaoMunicipal"
})
@Getter
@Setter
@ToString
public class IdentificacaoTomador {
    @XmlElement(name = "CpfCnpj")
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    static public IdentificacaoTomador fromString(String line) {
        String inscricaoMunicipal = line.substring(87, 95);
        CpfCnpj cpfCnpj = CpfCnpj.fromString(line);

        IdentificacaoTomador identificacaoTomador = new IdentificacaoTomador();
        identificacaoTomador.setCpfCnpj(cpfCnpj);
        identificacaoTomador.setInscricaoMunicipal(inscricaoMunicipal);

        return identificacaoTomador;
    }
}
