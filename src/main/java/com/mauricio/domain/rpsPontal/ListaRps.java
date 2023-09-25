package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rps"
})
@Getter
@Setter
public class ListaRps {
    @XmlElement(name = "Rps", required = true)
    private List<DeclaracaoPrestacaoServico> rps;
}
