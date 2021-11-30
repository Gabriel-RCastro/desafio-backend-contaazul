package br.com.gabrielcastro.desafiobackend.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoboTest {

    Robo robo = new Robo();

    @Test
    public void deveMovimentarComRotacaoParaDireita() {
        robo.executarComandos("MMRMMRMM");
        String resultado = robo.getPosicao().toString();
        assertEquals("(2, 0, S)", resultado);
    }

    @Test
    public void deveMovimentarParaEsquerda() {
        robo.executarComandos("MML");
        String resultado = robo.getPosicao().toString();
        assertEquals("(0, 2, W)", resultado);
    }

    @Test
    public void naoDeveMovimentarComComandosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            robo.executarComandos("AAA");
        });
    }

    @Test
    public void naoDeveMovimentarParaForaDoTerreno() {
        assertThrows(IllegalArgumentException.class, () -> {
            robo.executarComandos("MMMMMMMMMMMMMMMMMMMMM");
        });
    }
}
