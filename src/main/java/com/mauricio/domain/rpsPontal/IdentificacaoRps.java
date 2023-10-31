package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.TipoRps;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcIdentificacaoRps", propOrder = {
        "numero",
        "serie",
        "tipo"
})
@Getter
@Setter
@ToString
public class IdentificacaoRps {
    @XmlElement(name = "Numero", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numero;

    @XmlElement(name = "Serie", required = true)
    private String serie;

    @XmlElement(name = "Tipo")
    private TipoRps tipo;

    public static IdentificacaoRps fromSpModel(RpsSp rpsSp) {
        IdentificacaoRps identificacaoRps = new IdentificacaoRps();
        identificacaoRps.setNumero(rpsSp.getNumero());
        identificacaoRps.setSerie(rpsSp.getSerie());
        identificacaoRps.setTipo(rpsSp.getTipo());

        return identificacaoRps;
    }
}
