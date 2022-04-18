package com.ceiba.alquiler.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilerTest {
    @Test
    @DisplayName("Deberia crear correctamente el alquiler si el cliente es de estado Estandar")
    void deberiaCrearCorrectamenteElAlquilerConEstadoEstandar() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).conCliente(new Cliente(1L, "Estiven", "Estandar")).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Estandar", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("DVD", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(alquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
        assertEquals("8.0" + " USD", alquiler.getValor());
    }

    @Test
    @DisplayName("Deberia crear correctamente el alquiler si el cliente es de estado Incumplimiento")
    void deberiaCrearCorrectamenteElAlquilerConEstadoIncumplimiento() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).conCliente(new Cliente(1L, "Estiven", "Incumplimiento")).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Incumplimiento", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("DVD", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(alquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
        assertEquals("9.6" + " USD", alquiler.getValor());
    }

    @Test
    @DisplayName("Deberia crear correctamente el alquiler si el cliente es de estado Incumplimiento X2")
    void deberiaCrearCorrectamenteElAlquilerConEstadoIncumplimientoX2() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).conCliente(new Cliente(1L, "Estiven", "Incumplimiento X2")).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Incumplimiento X2", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("DVD", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(alquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
        assertEquals("12.0" + " USD", alquiler.getValor());
    }

    @Test
    void deberiaFallarSiElClienteEstaEnEstadoVetado() {

        //Arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conCliente(new Cliente(1L, "Estiven", "Vetado")).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    alquilerTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "El cliente se encuentra vetado y por lo tanto no puede crear un alquiler");
    }

    @Test
    @DisplayName("Deberia crear correctamente el alquiler si la pelicula es de formato DVD")
    void deberiaCrearCorrectamenteElAlquilerConLaPeliculaDVD() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).conPelicula(new Pelicula(1L, "StarWars", "DVD")).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Incumplimiento", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("DVD", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(alquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
        assertEquals("9.6" + " USD", alquiler.getValor());
    }

    @Test
    @DisplayName("Deberia crear correctamente el alquiler si la pelicula es de formato Blue-ray")
    void deberiaCrearCorrectamenteElAlquilerConLaPeliculaBlueRay() {
        // arrange
        LocalDate fechaAlquiler = LocalDate.now();
        //act
        Alquiler alquiler= new AlquilerTestDataBuilder().conId(1L).conPelicula(new Pelicula(1L, "StarWars", "Blue-ray")).build();
        //assert
        assertEquals(1, alquiler.getId());

        assertEquals(1, alquiler.getCliente().getId());
        assertEquals("Estiven", alquiler.getCliente().getNombre());
        assertEquals("Incumplimiento", alquiler.getCliente().getEstado());

        assertEquals(1, alquiler.getPelicula().getId());
        assertEquals("StarWars", alquiler.getPelicula().getNombre());
        assertEquals("Blue-ray", alquiler.getPelicula().getFormato());

        assertEquals(fechaAlquiler, alquiler.getFechaAlquiler());
        assertEquals(alquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
        assertEquals("14.4" + " USD", alquiler.getValor());
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
