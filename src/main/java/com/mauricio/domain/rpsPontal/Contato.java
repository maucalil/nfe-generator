package com.mauricio.domain.rpsPontal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcContato", propOrder = {
        "telefone",
        "email"
})
@Getter
@Setter
@ToString
public class Contato {
    @XmlElement(name = "Telefone")
    private String telefone;

    @XmlElement(name = "Email")
    private String email;

    public static Contato fromString(String line) {
        // nao tem telefone
        String email = line.substring(365, 440).strip();

        Contato contato = new Contato();
        contato.setEmail(email);

        return contato;
    }
}
