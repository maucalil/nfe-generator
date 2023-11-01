package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "EnviarLoteRpsSincronoEnvio", namespace = "http://www.abrasf.org.br/nfse.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "loteRps",
        "signature"
})
@Getter
@Setter
public class EnviarLoteRps {
    @XmlElement(name = "LoteRps", required = true)
    protected LoteRps loteRps;

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected String signature;
}
