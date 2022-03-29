package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        //- assert
        assertEquals(10L,idAlquiler);
        Mockito.verify(repositorioAlquiler, Mockito.times(1)).crear(alquiler);
    }
}
