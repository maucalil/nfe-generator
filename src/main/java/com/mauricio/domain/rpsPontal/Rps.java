package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.converters.StringConverter;
import com.mauricio.domain.enums.StatusRps;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcInfRps", propOrder = {
        "identificacaoRps",
        "dataEmissao",
        "status",
//        "rpsSubstituido"
})
@Getter
@Setter
@ToString
public class Rps {
    @XmlElement(name = "IdentificacaoRps", required = true)
    private IdentificacaoRps identificacaoRps;

    @XmlElement(name = "DataEmissao", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar dataEmissao;

    @XmlElement(name = "Status")
    private StatusRps status;

    public static Rps fromSpModel(RpsSp rpsSp) {
        IdentificacaoRps  identificacaoRps = IdentificacaoRps.fromSpModel(rpsSp);
        String dataEmissao = rpsSp.getDataEmissao();
        StatusRps status = StatusRps.fromChar(rpsSp.getSituacao());

        Rps rps = new Rps();
        rps.setIdentificacaoRps(identificacaoRps);
        rps.setDataEmissao(StringConverter.toXMLGregorianCalendar(dataEmissao));
        rps.setStatus(status);

        return rps;
    }

//    @XmlElement(name = "RpsSubstituido")
//    private IdentificacaoRps rpsSubstituido;

//    @XmlAttribute(name = "Id")
//    private String id;
}
