package br.com.gabrielcastro.desafiobackend.model.enums;

import lombok.Getter;

public enum Sentidos {

    N(0),
    E(1),
    S(2),
    W(3);

    @Getter
    private final int ordinal;

    Sentidos(int ordinal) {
        this.ordinal = ordinal;
    }
}
