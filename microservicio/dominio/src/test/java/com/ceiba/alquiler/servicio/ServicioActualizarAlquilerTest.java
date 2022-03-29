package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarAlquilerTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del alquiler")
    void deberiaValidarLaExistenciaPreviaDelAlquiler() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conId(1L).build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarAlquiler servicioActualizarAlquiler = new ServicioActualizarAlquiler(repositorioAlquiler);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.ejecutar(alquiler), ExcepcionDuplicidad.class,"El alquiler no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente el alquiler")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conId(1L).build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarAlquiler servicioActualizarAlquiler = new ServicioActualizarAlquiler(repositorioAlquiler);
        // act
        servicioActualizarAlquiler.ejecutar(alquiler);
        //assert
        Mockito.verify(repositorioAlquiler,Mockito.times(1)).actualizar(alquiler);
    }
}
