package me.jarbasgouveia.organizadordetimes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/jogador")
@Tag(name = "Jogador Controller", description = "Controller para gerenciar os jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Operation(summary = "Cria um jogador", description = "Cria um jogador com o nome passado no corpo da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cenário em que o jogador é criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Quando o nome do jogador é vazio ou nulo")
    })
    @PostMapping
    public ResponseEntity<Void> criarJogador(@RequestBody Jogador nome) {
        try {
            jogadorService.criarJogador(nome);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Exclui todos os jogadores", description = "Exclui todos os jogadores do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Exluiu todos os jogadores"),
            @ApiResponse(responseCode = "400", description = "Não há jogadores para excluir")
    })
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
