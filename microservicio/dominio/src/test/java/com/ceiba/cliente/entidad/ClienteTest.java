package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente() {

        //act
        Cliente cliente= new ClienteTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, cliente.getId());
        assertEquals("Estiven", cliente.getNombre());
        assertEquals("Vetado", cliente.getEstado());
    }

    @Test
    void deberiaFallarSinNombreDeCliente() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    void noDeberiaFallarSinEstadoDeCliente() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre("Estiven").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar un valor");
    }
}
