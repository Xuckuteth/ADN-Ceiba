package com.ceiba.pelicula.servicio.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.Pelicula;


public class PeliculaTestDataBuilder {
    Long id;
    String nombre;
    String formato;

    public PeliculaTestDataBuilder() {
        nombre = "Harry Potter: La Piedra Filosofal";
        formato = "Blue-ray";
    }

    public PeliculaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PeliculaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PeliculaTestDataBuilder conFormato(String formato) {
        this.formato = formato;
        return this;
    }

    public Pelicula build() {
        return new Pelicula(id,nombre,formato);
    }

}
