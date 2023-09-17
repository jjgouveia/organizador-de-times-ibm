package me.jarbasgouveia.organizadordetimes.services.impl;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.domain.repositories.JogadorRepository;
import me.jarbasgouveia.organizadordetimes.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;


    @Override
    public void criarJogador(Jogador jogador) {
        if (jogador.getNome() == null || jogador.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        jogadorRepository.save(jogador);
    }

    @Override
    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }

    @Override
    public void deletarJogadores() {
        if(jogadorRepository.findAll().isEmpty()){
            throw new NoSuchElementException("Não há jogadores para deletar");
        }
        jogadorRepository.deleteAll();
    }
}
