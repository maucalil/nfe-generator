package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.IssRetido;
import com.mauricio.domain.enums.SimNao;
import com.mauricio.domain.rpsSP.DadosServicoSp;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDadosServico", propOrder = {
        "valores",
        "issRetido",
        "responsavelRetencao",
        "itemListaServico",
        "codigoCnae",
        "codigoTributacaoMunicipio",
        "discriminacao",
        "codigoMunicipio",
        "codigoPais",
        "exigibilidadeISS",
        "municipioIncidencia",
        "numeroProcesso"
})
@Getter
@Setter
public class DadosServico {
    @XmlElement(name = "Valores", required = true)
    protected ValoresDeclaracaoServico valores;
    @XmlElement(name = "IssRetido")
    protected SimNao issRetido;
    @XmlElement(name = "ResponsavelRetencao")
    protected Byte responsavelRetencao;
    @XmlElement(name = "ItemListaServico", required = true)
    protected String itemListaServico;

    @XmlElement(name = "CodigoCnae")
    protected Integer codigoCnae;

    @XmlElement(name = "CodigoTributacaoMunicipio")
    protected String codigoTributacaoMunicipio;

    @XmlElement(name = "Discriminacao", required = true)
    protected String discriminacao;

    @XmlElement(name = "CodigoMunicipio", required = true)
    protected int codigoMunicipio;

    @XmlElement(name = "CodigoPais")
    protected String codigoPais;

    @XmlElement(name = "ExigibilidadeISS", required = true)
    protected byte exigibilidadeISS;

    @XmlElement(name = "MunicipioIncidencia")
    protected Integer municipioIncidencia;

    @XmlElement(name = "NumeroProcesso")
    protected String numeroProcesso;

    public static DadosServico fromSpModel(DadosServicoSp dadosServicoSp) {
        SimNao issRetido;
        if (dadosServicoSp.getIssRetido() == IssRetido.TOMADOR) {
            issRetido = SimNao.SIM;
        } else {
            issRetido = SimNao.NAO;
        }

        ValoresDeclaracaoServico valores = ValoresDeclaracaoServico.fromSpModel(dadosServicoSp.getValoresServico());

        DadosServico dadosServico = new DadosServico();
        dadosServico.setValores(valores);
        dadosServico.setIssRetido(issRetido);
        dadosServico.setDiscriminacao(dadosServicoSp.getDiscriminacao());
        return null;
    }
}
