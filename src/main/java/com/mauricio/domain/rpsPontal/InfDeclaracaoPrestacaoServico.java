package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.RegimeEspecialTributacao;
import com.mauricio.domain.enums.SimNao;
import com.mauricio.domain.rpsSP.RpsSp;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
public class InfDeclaracaoPrestacaoServico {
    @XmlElement(name = "Rps")
    private Rps rps;

    @XmlElement(name = "Competencia", required = true)
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar competencia;

    @XmlElement(name = "Servico", required = true)
    private DadosServico servico;

    @XmlElement(name = "Prestador", required = true)
    private IdentificacaoPrestador prestador;

    @XmlElement(name = "Tomador")
    private DadosTomador tomador;

    @XmlElement(name = "RegimeEspecialTributacao")
    private RegimeEspecialTributacao regimeEspecialTributacao;

    @XmlElement(name = "OptanteSimplesNacional", required = true)
    private SimNao optanteSimplesNacional;

    @XmlElement(name = "IncentivoFiscal", required = true)
    private SimNao incentivoFiscal;

    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String id;

    public static InfDeclaracaoPrestacaoServico fromSpModel(RpsSp rpsSp) {
        Rps rps = Rps.fromSpModel(rpsSp);
        DadosTomador tomador = rpsSp.getDadosServico().getDadosTomador();
        DadosServico servico = DadosServico.fromSpModel(rpsSp.getDadosServico());

        IdentificacaoPrestador prestador = new IdentificacaoPrestador();

        InfDeclaracaoPrestacaoServico infDeclaracaoPrestacaoServico = new InfDeclaracaoPrestacaoServico();
        infDeclaracaoPrestacaoServico.setRps(rps);
        infDeclaracaoPrestacaoServico.setCompetencia(rps.getDataEmissao());
        infDeclaracaoPrestacaoServico.setServico(servico);
        infDeclaracaoPrestacaoServico.setPrestador(prestador);
        infDeclaracaoPrestacaoServico.setTomador(tomador);
        infDeclaracaoPrestacaoServico.setOptanteSimplesNacional(SimNao.SIM);
        infDeclaracaoPrestacaoServico.setRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP);
        infDeclaracaoPrestacaoServico.setIncentivoFiscal(SimNao.NAO);
        infDeclaracaoPrestacaoServico.setId("rps" + rps.getIdentificacaoRps().getNumero());

        return infDeclaracaoPrestacaoServico;
    }
}
