package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.rpsSP.LoteRpsSp;
import com.mauricio.domain.utils.ConstantUtils;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

// Deve ser assinado
@XmlRootElement(name = "LoteRps")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcLoteRps", propOrder = {
        "numeroLote",
        "cpfCnpj",
        "inscricaoMunicipal",
        "quantidadeRps",
        "listaRps"
})
@Getter
@Setter
@ToString
public class LoteRps {
    @XmlElement(name = "NumeroLote", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger numeroLote;

    @XmlElement(name = "CpfCnpj", required = true)
    private CpfCnpj cpfCnpj; // do prestador

    @XmlElement(name = "InscricaoMunicipal")
    private String inscricaoMunicipal; // do prestador

    @XmlElement(name = "QuantidadeRps")
    private int quantidadeRps;

    @XmlElement(name = "ListaRps", required = true)
    private ListaRps listaRps;

    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String id;

    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String versao;

    public static LoteRps fromLoteRpsSp(LoteRpsSp loteRpsSp, BigInteger nroLote) {
        String inscricaoMuncipal = loteRpsSp.getCabecalho().getInscricaoMunicipalPrestador();
        int quantidadeRps = loteRpsSp.getRodape().getQntLinhaDetalhes();

        CpfCnpj cnpj = CpfCnpj.getDefault();
        ListaRps listaRps = ListaRps.fromSpModel(loteRpsSp.getRpsList());

        LoteRps loteRps = new LoteRps();
        loteRps.setCpfCnpj(cnpj);
        loteRps.setNumeroLote(nroLote);
        loteRps.setInscricaoMunicipal(inscricaoMuncipal);
        loteRps.setQuantidadeRps(quantidadeRps);
        loteRps.setListaRps(listaRps);
        loteRps.setVersao(ConstantUtils.VERSAO_LOTE_RPS);
        loteRps.setId("lote" + loteRps.numeroLote);
        return loteRps;
    }
}
