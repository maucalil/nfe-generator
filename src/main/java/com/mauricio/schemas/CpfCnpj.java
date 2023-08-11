package com.mauricio.schemas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcCpfCnpj", propOrder = {
        "cpf",
        "cnpj"
})
@Getter
@Setter
public class CpfCnpj {
    @XmlElement(name = "Cpf")
    private String cpf;

    @XmlElement(name = "Cnpj")
    private String cnpj;
}
