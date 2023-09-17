package me.jarbasgouveia.organizadordetimes.domain.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "tb_jogador")
public class Jogador extends BaseEntity {
    @Column(nullable = false)
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
    }
    public Jogador() {
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
