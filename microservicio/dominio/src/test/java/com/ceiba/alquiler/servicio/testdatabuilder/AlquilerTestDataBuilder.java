package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import java.time.LocalDate;


public class AlquilerTestDataBuilder {
    private Long id;
    private Cliente cliente;
    private Pelicula pelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private String valor;

    public AlquilerTestDataBuilder() {
        cliente = new Cliente(1L,"Estiven","Estandar");
        pelicula = new Pelicula(1L,"StarWars","DVD");
        fechaAlquiler = LocalDate.now();
        fechaDevolucion = LocalDate.now().plusDays(10);
        valor = "10";
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

    public AlquilerTestDataBuilder conFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }

    public AlquilerTestDataBuilder conFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }

    public AlquilerTestDataBuilder conValor(String valor) {
        this.valor = valor;
        return this;
    }

    public Alquiler build() {
        return new Alquiler(id, cliente, pelicula, fechaAlquiler,fechaDevolucion,valor);
    }

}
