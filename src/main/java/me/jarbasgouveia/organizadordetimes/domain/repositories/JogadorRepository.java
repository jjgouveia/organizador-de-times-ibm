package me.jarbasgouveia.organizadordetimes.domain.repositories;

import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import me.jarbasgouveia.organizadordetimes.domain.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
