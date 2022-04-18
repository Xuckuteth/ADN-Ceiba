package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAlquilerTest {
    @Test
    @DisplayName("Deberia eliminar el alquiler llamando al repositorio")
    void deberiaEliminarElAlquilerLlamandoAlRepositorio() {
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        ServicioEliminarAlquiler servicioEliminarAlquiler = new ServicioEliminarAlquiler(repositorioAlquiler);

        servicioEliminarAlquiler.ejecutar(1l);

        Mockito.verify(repositorioAlquiler, Mockito.times(1)).eliminar(1l);

    }

}
