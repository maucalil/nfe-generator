package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcDadosTomador", propOrder = {
        "identificacaoTomador",
        "razaoSocial",
        "endereco",
        "contato"
})
@Getter
@Setter
@ToString
public class DadosTomador {
    @XmlElement(name = "IdentificacaoTomador")
    private IdentificacaoTomador identificacaoTomador;

    private String inscricaoEstadual;

    @XmlElement(name = "RazaoSocial")
    private String razaoSocial;

    @XmlElement(name = "Endereco")
    private Endereco endereco;

    @XmlElement(name = "Contato")
    private Contato contato;

    public static DadosTomador fromString(String line) {
        IdentificacaoTomador identificacaoTomador = IdentificacaoTomador.fromString(line);
        String razaoSocial = line.substring(107, 182).strip();
        Endereco endereco = Endereco.fromString(line);
        Contato contato = Contato.fromString(line);

        DadosTomador dadosTomador = new DadosTomador();
        dadosTomador.setIdentificacaoTomador(identificacaoTomador);
        dadosTomador.setRazaoSocial(razaoSocial);
        dadosTomador.setEndereco(endereco);
        dadosTomador.setContato(contato);

        if (identificacaoTomador.getCpfCnpj().isSemCpf()) {
            String inscricaoEstadual = line.substring(95, 107);
            dadosTomador.setInscricaoEstadual(inscricaoEstadual);
        }

        return dadosTomador;
    }
}
