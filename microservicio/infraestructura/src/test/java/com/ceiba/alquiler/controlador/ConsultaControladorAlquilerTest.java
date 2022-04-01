package com.ceiba.alquiler.controlador;

import com.ceiba.ApplicationMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorAlquiler.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorAlquilerTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar alquileres")
    void deberiaListarAlquileres() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/alquileres")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].cliente", is(1)))
                .andExpect(jsonPath("$[0].pelicula", is(1)))
                .andExpect(jsonPath("$[0].fechaAlquiler", is(LocalDate.now().toString())))
                .andExpect(jsonPath("$[0].fechaDevolucion", is(LocalDate.now().toString())))
                .andExpect(jsonPath("$[0].valor", is("10")));
    }

    @Test
    @DisplayName("Deberia consultar un alquiler por su id")
    void deberiaConsultarUnAlquilerPorSuId() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/alquileres/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("cliente", is(1)))
                .andExpect(jsonPath("pelicula", is(1)))
                .andExpect(jsonPath("fechaAlquiler", is(LocalDate.now().toString())))
                .andExpect(jsonPath("fechaDevolucion", is(LocalDate.now().toString())))
                .andExpect(jsonPath("valor", is("10")));
    }
}
