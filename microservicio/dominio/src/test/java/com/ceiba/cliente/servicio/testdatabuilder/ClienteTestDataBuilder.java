package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import java.time.LocalDateTime;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String estado;

    public ClienteTestDataBuilder() {
        nombre = "Estiven";
        estado = "Vetado";
    }

    public ClienteTestDataBuilder conId (Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public Cliente build() {
        return new Cliente(id, nombre, estado);
    }
}
