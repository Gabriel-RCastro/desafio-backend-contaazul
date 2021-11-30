package br.com.gabrielcastro.desafiobackend.model;

import lombok.Getter;

public class Terreno {

    @Getter
    private final int largura, altura;

    public Terreno(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }
}
