package br.com.gabrielcastro.desafiobackend.model;

import br.com.gabrielcastro.desafiobackend.model.enums.Sentidos;
import lombok.Data;

@Data
public class Posicao {

    private int x, y;
    private Sentidos sentido;

    public Posicao(int x, int y, Sentidos sentido) {
        this.x = x;
        this.y = y;
        this.sentido = sentido;
    }

    public Posicao mover() {
        Posicao posicao;
        switch (this.sentido) {
            case N:
                posicao = new Posicao(this.x, this.y + 1, Sentidos.N);
                break;
            case E:
                posicao = new Posicao(this.x + 1, this.y, Sentidos.E);
                break;
            case S:
                posicao = new Posicao(this.x, this.y - 1, Sentidos.S);
                break;
            case W:
                posicao = new Posicao(this.x - 1, this.y, Sentidos.W);
                break;
            default:
                posicao = this;
        }
        return posicao;
    }

    public Posicao virarParaDireita() {
        int novaPosicao = this.sentido.getOrdinal() + 1;
        int valorOrdinal = novaPosicao > Sentidos.values().length - 1 ? 0 : novaPosicao;
        return new Posicao(this.x, this.y, Sentidos.values()[valorOrdinal]);
    }

    public Posicao virarParaEsquerda() {
        int novaPosicao = this.sentido.getOrdinal() - 1;
        int valorOrdinal = novaPosicao < 0 ? Sentidos.values().length - 1 : novaPosicao;
        return new Posicao(this.x, this.y, Sentidos.values()[valorOrdinal]);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.sentido + ")";
    }
}
