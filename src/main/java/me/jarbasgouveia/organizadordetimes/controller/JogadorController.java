package me.jarbasgouveia.organizadordetimes.controller;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Void> criarJogador(@RequestBody Jogador nome) {
        try {
            jogadorService.criarJogador(nome);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deletarJogadores(){
        try {
            jogadorService.deletarJogadores();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }

    }





}
