package br.com.gabrielcastro.desafiobackend.controller;

import br.com.gabrielcastro.desafiobackend.model.Robo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

    @PostMapping(
            value = "/{comandos}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> executarComandos(@PathVariable("comandos") String comandos) {
        try {
            Robo robo = new Robo();
            robo.executarComandos(comandos);
            return ResponseEntity.ok(robo.getPosicao().toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
