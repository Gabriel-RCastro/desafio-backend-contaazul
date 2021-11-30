package br.com.gabrielcastro.desafiobackend.model;

import br.com.gabrielcastro.desafiobackend.model.enums.Sentidos;
import lombok.Getter;

public class Robo {

    @Getter
    private Posicao posicao;
    private final Terreno terreno;

    public Robo() {
        this.posicao = new Posicao(0, 0, Sentidos.N);
        this.terreno = new Terreno(5, 5);
    }

    public void executarComandos(String comandos) {
        String[] listaDeComandos = comandos.split("");
        for (String comando : listaDeComandos) {
            executarComando(comando);
        }
    }

    private void executarComando(String comando) {
        switch (comando) {
            case "M":
                this.mover();
                break;
            case "R":
                this.posicao = this.posicao.virarParaDireita();
                break;
            case "L":
                this.posicao = this.posicao.virarParaEsquerda();
                break;
            default:
                throw new IllegalArgumentException("Esse comando é não permitido!");
        }
    }

    private void mover() {
        Posicao novaPosicao = this.posicao.mover();
        if (this.podeMoverPara(novaPosicao.getX(), novaPosicao.getY())) {
            this.posicao = novaPosicao;
        } else {
            throw new IllegalArgumentException("Esse movimento não é permitido!");
        }
    }

    private boolean podeMoverPara(int x, int y) {
        return (x >= 0 && x < this.terreno.getLargura()) && (y >= 0 && y < this.terreno.getAltura());
    }
}
