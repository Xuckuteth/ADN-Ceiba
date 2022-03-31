package com.ceiba.pelicula.servicio.testdatabuilder;

import com.ceiba.pelicula.comando.ComandoPelicula;
import java.util.UUID;

public class ComandoPeliculaTestDataBuilder {

    private Long id;
    private String nombre;
    private String formato;

    public ComandoPeliculaTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        formato = "DVD";
    }

    public ComandoPeliculaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPelicula build() {
        return new ComandoPelicula(id, nombre, formato);
    }
}
