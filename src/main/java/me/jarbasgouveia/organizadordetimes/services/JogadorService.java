package me.jarbasgouveia.organizadordetimes.services;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;

import java.util.List;

public interface JogadorService {
    void criarJogador(String nome);
    List<Jogador> listarJogadores();


}
