package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.utils.ConstantUtils;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoPrestador", propOrder = {
        "cpfCnpj",
        "inscricaoMunicipal"
})
@Getter
@Setter
@ToString
public class IdentificacaoPrestador {
    @XmlElement(name = "CpfCnpj")
    private CpfCnpj cpfCnpj;

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    public IdentificacaoPrestador() {
        this.cpfCnpj = CpfCnpj.getDefault();
        this.inscricaoMunicipal = ConstantUtils.INSCRICAO_MUNICIPAL;
    }
}
