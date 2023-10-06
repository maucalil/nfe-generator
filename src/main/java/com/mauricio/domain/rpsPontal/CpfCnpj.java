package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.IndicadorCpfCnpj;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcCpfCnpj", propOrder = {
        "cpf",
        "cnpj"
})
@Getter
@Setter
@ToString
public class CpfCnpj {
    @XmlElement(name = "Cpf")
    private String cpf;

    @XmlElement(name = "Cnpj")
    private String cnpj;

    private boolean isPJ;

    public static CpfCnpj fromString(String line) {
        CpfCnpj cpfCnpj = new CpfCnpj();
        int codigo = Integer.parseInt(line.substring(72, 73));

        if (codigo == IndicadorCpfCnpj.CPF.getCodigo()) {
            String cpf = line.substring(77, 87);
            cpfCnpj.setCpf(cpf);
            cpfCnpj.setPJ(false);
        } else if (codigo == IndicadorCpfCnpj.CNPJ.getCodigo()) {
            String cnpj = line.substring(73, 87);
            cpfCnpj.setCnpj(cnpj);
            cpfCnpj.setPJ(true);
        } else if (codigo == IndicadorCpfCnpj.SEM_CPF.getCodigo()) {
            // TODO ver  o que fazer aqui
        }

        return cpfCnpj;
    }

    public boolean isSemCpf() {
        boolean hasCpf = this.getCpf() != null;
        boolean hasCnpj = this.getCnpj() != null;

        return !(hasCpf || hasCnpj);
    }
}
