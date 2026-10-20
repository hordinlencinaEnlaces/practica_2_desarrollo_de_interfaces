package es.cpifp.losenlaces.cinelista;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CinelistaApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void anadirYEliminarPelicula() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());

        mvc.perform(post("/peliculas")
                .param("titulo", "Blade Runner")
                .param("director", "Ridley Scott")
                .param("anio", "1982")
                .param("genero", "Ciencia ficción"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"));

        mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("Blade Runner")));

        mvc.perform(post("/peliculas/1/eliminar"))
            .andExpect(status().is3xxRedirection());

        mvc.perform(get("/"))
            .andExpect(content().string(org.hamcrest.Matchers.not(org.hamcrest.Matchers.containsString("Blade Runner"))));
    }
}
