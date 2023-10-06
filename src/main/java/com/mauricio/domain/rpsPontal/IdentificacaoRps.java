package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoRps", propOrder = {
        "numero",
        "serie",
        "tipo"
})
@Getter
@Setter
public class IdentificacaoRps {
    @XmlElement(name = "Numero", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numero;

    @XmlElement(name = "Serie", required = true)
    private String serie;

    @XmlElement(name = "Tipo")
    private byte tipo;
}
