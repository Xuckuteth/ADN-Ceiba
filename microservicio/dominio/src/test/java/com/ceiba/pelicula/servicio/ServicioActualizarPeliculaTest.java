package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarPeliculaTest {
    @Test
    @DisplayName("Deberia validar la existencia previa de la Pelicula")
    void deberiaValidarLaExistenciaPreviaDeLaPelicula() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPelicula servicioActualizarPelicula = new ServicioActualizarPelicula(repositorioPelicula);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPelicula.ejecutar(pelicula), ExcepcionDuplicidad.class,"La película no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPelicula servicioActualizarPelicula = new ServicioActualizarPelicula(repositorioPelicula);
        // act
        servicioActualizarPelicula.ejecutar(pelicula);
        //assert
        Mockito.verify(repositorioPelicula,Mockito.times(1)).actualizar(pelicula);
    }
}
