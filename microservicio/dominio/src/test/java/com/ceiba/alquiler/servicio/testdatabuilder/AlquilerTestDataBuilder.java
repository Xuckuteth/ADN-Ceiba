package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

import java.time.LocalDate;


public class AlquilerTestDataBuilder {
    private Long id;
    private Cliente cliente;
    private Pelicula pelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private String valor;

    public AlquilerTestDataBuilder() {
        cliente = new Cliente(1L,"Estiven","Incumplimiento");
        pelicula = new Pelicula(1L,"StarWars","DVD");
    }

    public AlquilerTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public AlquilerTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public AlquilerTestDataBuilder conPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        return this;
    }


    public Alquiler build() {
        return new Alquiler(id, cliente, pelicula);
    }


}
