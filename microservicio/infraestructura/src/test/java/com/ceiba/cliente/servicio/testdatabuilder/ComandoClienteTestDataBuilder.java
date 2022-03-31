package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import java.util.UUID;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String estado;

    public ComandoClienteTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        estado = "Estandar";
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id, nombre, estado);
    }
}
