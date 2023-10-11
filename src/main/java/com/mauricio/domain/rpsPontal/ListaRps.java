package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public static ListaRps fromSpModel(List<RpsSp> rpsSpList) {
        List<DeclaracaoPrestacaoServico> rpsList = new ArrayList<>();

        for (RpsSp rpsSp : rpsSpList) {
            DeclaracaoPrestacaoServico rps = DeclaracaoPrestacaoServico.fromSpModel(rpsSp);
        }
        return null;
    }
}
