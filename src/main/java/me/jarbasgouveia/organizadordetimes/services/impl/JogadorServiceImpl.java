package me.jarbasgouveia.organizadordetimes.services.impl;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.domain.repositories.JogadorRepository;
import me.jarbasgouveia.organizadordetimes.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    public void criarJogador(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        Jogador jogador = new Jogador(nome);
        jogadorRepository.save(jogador);
    }
}
