package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPeliculaTest {
    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia de la Pelicula")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaPelicula() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPelicula servicioCrearPelicula = new ServicioCrearPelicula(repositorioPelicula);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPelicula.ejecutar(pelicula), ExcepcionDuplicidad.class,"El nombre de la película ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la pelicula de manera correcta")
    void deberiaCrearLaPeliculaDeManeraCorrecta() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPelicula.crear(pelicula)).thenReturn(10L);
        ServicioCrearPelicula servicioCrearPelicula = new ServicioCrearPelicula(repositorioPelicula);
        // act
        Long idPelicula = servicioCrearPelicula.ejecutar(pelicula);
        //- assert
        assertEquals(10L,idPelicula);
        Mockito.verify(repositorioPelicula, Mockito.times(1)).crear(pelicula);
    }
}
