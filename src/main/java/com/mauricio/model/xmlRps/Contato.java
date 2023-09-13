package com.mauricio.model.xmlRps;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcContato", propOrder = {
        "telefone",
        "email"
})
public class Contato {
    @XmlElement(name = "Telefone")
    private String telefone;

    @XmlElement(name = "Email")
    private String email;
}
