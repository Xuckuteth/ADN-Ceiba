package com.ceiba.pelicula.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeliculaTest {

    @Test
    @DisplayName("Deberia crear correctamente la pelicula")
    void deberiaCrearCorrectamenteLaPelicula() {
        //act
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).conNombre("Harry Potter: La Piedra Filosofal").conFormato("Blue-ray").build();
        //assert
        assertEquals(1, pelicula.getId());
        assertEquals("Harry Potter: La Piedra Filosofal", pelicula.getNombre());
        assertEquals("Blue-ray", pelicula.getFormato());
    }

    @Test
    void deberiaFallarSinNombreDePelicula() {

        //Arrange
        PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    peliculaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de la película");
    }

    @Test
    void deberiaFallarSinFormatoDePelicula() {

        //Arrange
        PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder().conFormato(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    peliculaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el formato de la película: ==> Blue-ray <== o ==> DVD <==");
    }
}
