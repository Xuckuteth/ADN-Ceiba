package com.ceiba.pelicula.servicio;

import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarPeliculaTest {
    @Test
    @DisplayName("Deberia eliminar el pelicula llamando al repositorio")
    void deberiaEliminarLaPeliculaLlamandoAlRepositorio() {
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        ServicioEliminarPelicula servicioEliminarPelicula = new ServicioEliminarPelicula(repositorioPelicula);

        servicioEliminarPelicula.ejecutar(1l);

        Mockito.verify(repositorioPelicula, Mockito.times(1)).eliminar(1l);

    }
}
