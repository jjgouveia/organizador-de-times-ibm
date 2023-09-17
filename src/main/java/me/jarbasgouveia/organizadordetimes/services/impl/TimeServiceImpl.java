package me.jarbasgouveia.organizadordetimes.services.impl;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.engine.JarbasGouveiaJr;
import me.jarbasgouveia.organizadordetimes.services.JogadorService;
import me.jarbasgouveia.organizadordetimes.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    JogadorService jogadorService;

    @Override
    public Map<String, List<String>> listarTimes() {
        List<String> jogadores = jogadorService.listarJogadores().stream().map(Jogador::getNome).toList();

        JarbasGouveiaJr jarbasGouveiaJr = new JarbasGouveiaJr();
        return jarbasGouveiaJr.organizarTimes(jogadores);
    }
}
