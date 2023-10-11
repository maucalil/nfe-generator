package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.SimNao;
import com.mauricio.domain.rpsSP.DadosServicoSp;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcInfDeclaracaoPrestacaoServico", propOrder = {
        "rps",
        "competencia",
        "servico",
        "prestador",
        "tomador",
//        "intermediario",
//        "construcaoCivil",
        "regimeEspecialTributacao",
        "optanteSimplesNacional",
        "incentivoFiscal"
})
@Getter
@Setter
public class InfDeclaracaoPrestacaoServico {
    @XmlElement(name = "Rps")
    private Rps rps; // InfRps talvez

    @XmlElement(name = "Competencia", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar competencia;

    @XmlElement(name = "Servico", required = true)
    private DadosServico servico;

    @XmlElement(name = "Prestador", required = true)
    private IdentificacaoPrestador prestador;

    @XmlElement(name = "Tomador")
    private DadosTomador tomador;

//    @XmlElement(name = "Intermediario")
//    private String intermediario; // TODO: change to DadosIntermediario

//    @XmlElement(name = "ConstrucaoCivil")
//    private String construcaoCivil; // TODO: change to DadosConstrucaoCivil

    @XmlElement(name = "RegimeEspecialTributacao")
    private Byte regimeEspecialTributacao;

    @XmlElement(name = "OptanteSimplesNacional", required = true)
    private SimNao optanteSimplesNacional;

    @XmlElement(name = "IncentivoFiscal", required = true)
    private SimNao incentivoFiscal;

    @XmlAttribute(name = "Id")
    private String id;

    public static InfDeclaracaoPrestacaoServico fromSpModel(RpsSp rpsSp) {
//        Rps rps = Rps.fromSpModel(rpsSp);
        DadosServico servico = DadosServico.fromSpModel(rpsSp.getDadosServico());

        IdentificacaoPrestador prestador = new IdentificacaoPrestador();

        InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico = new InfDeclaracaoPrestacaoServico();
        infDeclaracaoPrestacaoServico.setServico(servico);
        infDeclaracaoPrestacaoServico.setPrestador(prestador);
        infDeclaracaoPrestacaoServico.setOptanteSimplesNacional(SimNao.SIM);
        infDeclaracaoPrestacaoServico.setIncentivoFiscal(SimNao.NAO);

        return infDeclaracaoPrestacaoServico;
    }
}
