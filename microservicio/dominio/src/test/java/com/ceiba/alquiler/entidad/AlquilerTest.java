package com.ceiba.alquiler.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilerTest {
    @Test
    @DisplayName("Deberia crear correctamente el alquiler")
    void deberiaCrearCorrectamenteElAlquiler() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now().plusDays(10);
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Estandar", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("DVD", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(fechaDevolucion, alquiler.getFechaDevolucion());
        assertEquals("10", alquiler.getValor());
    }

    @Test
    void deberiaFallarSinCliente() {

        //Arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conCliente(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alquilerTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un cliente");
    }

    @Test
    void deberiaFallarSinPelicula() {

        //Arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conPelicula(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alquilerTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar una pelicula");
    }

}
