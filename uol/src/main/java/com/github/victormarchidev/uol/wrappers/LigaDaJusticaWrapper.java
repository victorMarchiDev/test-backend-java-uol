package com.github.victormarchidev.uol.wrappers;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "liga_da_justica")
@XmlAccessorType(XmlAccessType.FIELD)
public class LigaDaJusticaWrapper {

    @XmlElementWrapper(name = "codinomes")
    @XmlElement(name = "codinome")
    private List<String> codinomes;

    public List<String> getCodinomes() {
        return codinomes;
    }

    public void setCodinomes(List<String> codinomes) {
        this.codinomes = codinomes;
    }
}
