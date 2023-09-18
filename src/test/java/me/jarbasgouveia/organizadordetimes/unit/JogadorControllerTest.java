package me.jarbasgouveia.organizadordetimes.unit;

import com.google.gson.Gson;
import me.jarbasgouveia.organizadordetimes.domain.entities.Jogador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class JogadorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testa se o endpoint /jogador retorna status 201 ao receber um jogador válido na requisição")
    public void testCriarJogador() throws Exception {
        Jogador jogador = new Jogador();
        jogador.setNome("Jarbas Gouveia");
        String json = new Gson().toJson(jogador);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/jogador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

        assert(result.getResponse().getStatus() == 201);
        assert (result.getResponse().getContentAsString().isEmpty());
    }

    @Test
    @DisplayName("Testa se o endpoint /jogador retorna status 400 ao não receber um nome na requisição")
    public void testErroAoCriarJogador() throws Exception {
        Jogador jogador = new Jogador();
        String json = new Gson().toJson(jogador);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/jogador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

        assert(result.getResponse().getStatus() == 400);
        assert (result.getResponse().getContentAsString().isEmpty());
    }

    @Test
    @DisplayName("Teste se o endpoint /jogador/all retorna status 202 ao receber uma requisição DELETE")
    public void deletaUsuariosTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/jogador")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(new Jogador("Jarbas Gouveia"))));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/jogador/all"))
                .andExpect(MockMvcResultMatchers.status().isAccepted()).andReturn();

        assert(result.getResponse().getStatus() == 202);
        assert (result.getResponse().getContentAsString().isEmpty());
    }
}
