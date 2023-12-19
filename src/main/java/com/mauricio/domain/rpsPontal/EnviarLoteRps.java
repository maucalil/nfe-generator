package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "EnviarLoteRpsSincronoEnvio")
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

    @XmlElement(name = "Signature")
    protected String signature;
}
