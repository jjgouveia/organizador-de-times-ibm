package me.jarbasgouveia.organizadordetimes.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TimeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testa se o endpoint /times retorna status 200 e um JSON vazio ao iniciar a aplicação")
    public void testListarTimes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/jogador/all"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/times"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();

        assert (result.getResponse().getStatus() == 200);
        assert (response.equals("{}"));
    };


};


