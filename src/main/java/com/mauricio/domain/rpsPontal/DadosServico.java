package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.ExigibilidadeIss;
import com.mauricio.domain.enums.IssRetido;
import com.mauricio.domain.enums.ResponsavelRetencao;
import com.mauricio.domain.enums.SimNao;
import com.mauricio.domain.rpsSP.DadosServicoSp;
import com.mauricio.domain.utils.ConstantUtils;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
public class DadosServico {
    @XmlElement(name = "Valores", required = true)
    protected ValoresDeclaracaoServico valores;

    @XmlElement(name = "IssRetido", required = true)
    protected SimNao issRetido;

    @XmlElement(name = "ResponsavelRetencao")
    protected ResponsavelRetencao responsavelRetencao; // obrigatório se issRetido for SIM (1)

    @XmlElement(name = "ItemListaServico", required = true)
    protected String itemListaServico;

    @XmlElement(name = "CodigoCnae")
    protected Integer codigoCnae;

    @XmlElement(name = "CodigoTributacaoMunicipio")
    protected String codigoTributacaoMunicipio; //  TODO remover?

    @XmlElement(name = "Discriminacao", required = true)
    protected String discriminacao;

    @XmlElement(name = "CodigoMunicipio", required = true)
    protected int codigoMunicipio;

    @XmlElement(name = "CodigoPais")
    protected String codigoPais;

    @XmlElement(name = "ExigibilidadeISS", required = true)
    protected ExigibilidadeIss exigibilidadeISS;

    @XmlElement(name = "MunicipioIncidencia")
    protected Integer municipioIncidencia; //  TODO remover?

    @XmlElement(name = "NumeroProcesso")
    protected String numeroProcesso; //  TODO remover?

    public static DadosServico fromSpModel(DadosServicoSp dadosServicoSp) {
        DadosServico dadosServico = new DadosServico();
        SimNao issRetido;

        if (dadosServicoSp.getIssRetido() == IssRetido.TOMADOR) {
            issRetido = SimNao.SIM;
            dadosServico.setResponsavelRetencao(ResponsavelRetencao.TOMADOR);
        } else {
            issRetido = SimNao.NAO;
        }

        ValoresDeclaracaoServico valores = ValoresDeclaracaoServico.fromSpModel(dadosServicoSp.getValoresServico());

        dadosServico.setValores(valores);
        dadosServico.setIssRetido(issRetido);
        dadosServico.setDiscriminacao(dadosServicoSp.getDiscriminacao());
        dadosServico.setCodigoMunicipio(ConstantUtils.CODIGO_PONTAL_IBGE);
        dadosServico.setCodigoPais(ConstantUtils.CODIGO_PAIS_IBGE);
        dadosServico.setExigibilidadeISS(ExigibilidadeIss.EXIGIVEL);
        dadosServico.setItemListaServico(ConstantUtils.CODIGO_LOCACAO_OU_VENDA); // TODO make an option to user

        return dadosServico;
    }
}
