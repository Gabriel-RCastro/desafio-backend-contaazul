package br.com.gabrielcastro.desafiobackend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MarsController.class)
public class MarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveExecutarOsComandos() throws Exception {
        String comandos = "MML";
        MockHttpServletResponse response = mockMvc.perform(
                post("/rest/mars/{comandos}", comandos)
        ).andReturn().getResponse();
        assertEquals(200, response.getStatus());
        assertEquals("(0, 2, W)", response.getContentAsString());
    }

    @Test
    public void naoDeveExecutarComandosInvalidos() throws Exception {
        String comandos = "AAA";
        MockHttpServletResponse response = mockMvc.perform(
                post("/rest/mars/{comandos}", comandos)
        ).andReturn().getResponse();
        assertEquals(400, response.getStatus());
    }

    @Test
    public void naoDeveExecutarComandosQueUltrapassemOTerreno() throws Exception {
        String comandos = "MMMMMMMMMMMMM";
        MockHttpServletResponse response = mockMvc.perform(
                post("/rest/mars/{comandos}", comandos)
        ).andReturn().getResponse();
        assertEquals(400, response.getStatus());
    }
}
