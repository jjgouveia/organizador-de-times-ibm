package me.jarbasgouveia.organizadordetimes.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JarbasGouveiaJr {



    public static Map<String, List<String>> organizarTimes(List<String> jogadores) {
        Map<String, List<String>> times = new HashMap<>();
        int i = 1;


        for (String jogador : jogadores) {
            String[] partesNome = jogador.split(" ");
            if (partesNome.length != 2) {
                continue;
            }
            String sobrenome = partesNome[1];
            String nomeTime = sobrenomeExiste(times, sobrenome) ? "Time " + i++ : "Time " + sobrenome.charAt(0);
            times.computeIfAbsent(nomeTime, key -> new ArrayList<>()).add(jogador);
        }

        return times;
    }

    private static boolean sobrenomeExiste(Map<String, List<String>> times, String sobrenome) {

        for (List<String> jogadoresTime : times.values()) {
            for (String jogador : jogadoresTime) {
                String sobrenomeJogador = jogador.split(" ")[1];
                if (sobrenomeJogador.equals(sobrenome)) {
                    return true;
                }
            }
        }
        return false;
    }
}

