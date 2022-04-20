package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearAlquilerTest {
    @Test
    @DisplayName("Deberia Crear el alquiler de manera correcta")
    void deberiaCrearElAlquilerDeManeraCorrecta() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAlquiler.crear(alquiler)).thenReturn(10L);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        // act
        Long idAlquiler = servicioCrearAlquiler.ejecutar(alquiler);
        Long cliente = alquiler.getCliente().getId();
        Long pelicula = alquiler.getPelicula().getId();
        LocalDate fechaAlquiler = alquiler.getFechaAlquiler();
        LocalDate fechaDevolucion = alquiler.getFechaDevolucion();
        String valor = alquiler.getValor();

        //- assert
        assertEquals(10L,idAlquiler);
        assertEquals(1L, cliente);
        assertEquals(1L, pelicula);
        assertEquals(LocalDate.now(), fechaAlquiler);
        assertEquals(LocalDate.parse("2022-04-26"), fechaDevolucion);
        assertEquals("9.6 USD", valor);
        Mockito.verify(repositorioAlquiler, Mockito.times(1)).crear(alquiler);
    }
}
