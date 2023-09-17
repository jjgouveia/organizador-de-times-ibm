package me.jarbasgouveia.organizadordetimes.domain.entities;

import jakarta.persistence.*;
import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "tb_time")
public class Time extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Jogador> jogadores = new ArrayList<>();


    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador jogador) {
        this.jogadores.add(jogador);
    }
}
