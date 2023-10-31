package com.mauricio.domain.rpsPontal;

import com.mauricio.domain.enums.IndicadorCpfCnpj;
import com.mauricio.domain.utils.ConstantUtils;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcCpfCnpj", propOrder = {
        "cpf",
        "cnpj"
})
@Getter
@ToString
public class CpfCnpj {
    @XmlElement(name = "Cpf")
    private String cpf;

    @XmlElement(name = "Cnpj")
    private String cnpj;

    @XmlTransient // faz o marshalling XML ignorar essa propriedade
    private boolean isPJ;

    public static CpfCnpj fromString(String line) {
        CpfCnpj cpfCnpj = new CpfCnpj();
        int codigo = Integer.parseInt(line.substring(72, 73));

        if (codigo == IndicadorCpfCnpj.CPF.getCodigo()) {
            String cpf = line.substring(77, 87);
            cpfCnpj.setCpf(cpf);
            cpfCnpj.setIsPJ(false);
        } else if (codigo == IndicadorCpfCnpj.CNPJ.getCodigo()) {
            String cnpj = line.substring(73, 87);
            cpfCnpj.setCnpj(cnpj);
            cpfCnpj.setIsPJ(true);
        } else if (codigo == IndicadorCpfCnpj.SEM_CPF.getCodigo()) {
            // TODO ver  o que fazer aqui
        }

        return cpfCnpj;
    }

    public static CpfCnpj getDefault() {
        CpfCnpj cnpj = new CpfCnpj();
        cnpj.setCnpj(ConstantUtils.CNPJ_IMOBILIARIA);

        return cnpj;
    }

    public boolean isSemCpf() {
        boolean hasCpf = this.getCpf() != null;
        boolean hasCnpj = this.getCnpj() != null;

        return !(hasCpf || hasCnpj);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        this.isPJ = false;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
        this.isPJ = true;
    }

    public void setIsPJ(boolean isPJ) {
        this.isPJ = isPJ;
    }
}
