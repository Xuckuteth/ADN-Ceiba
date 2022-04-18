package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;


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

    public ClienteTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Cliente build() {
        return new Cliente(id, nombre, estado);
    }

}
