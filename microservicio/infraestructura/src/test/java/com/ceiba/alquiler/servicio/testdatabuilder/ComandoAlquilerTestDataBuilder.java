package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import java.time.LocalDate;


public class ComandoAlquilerTestDataBuilder {
    private Long id;
    private Cliente cliente;
    private Pelicula pelicula;
    public LocalDate fechaAlquiler;
    public LocalDate fechaDevolucion;
    public String valor;

    public ComandoAlquilerTestDataBuilder() {
        id = 1L;
        cliente = new Cliente(1L, "Juan", "Estandar");
        pelicula = new Pelicula(1L, "Matrix", "DVD");
        fechaAlquiler = LocalDate.now();
        fechaDevolucion = LocalDate.now().minusDays(2);
        valor = "10";
    }

    public ComandoAlquilerTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        return this;
    }

    public ComandoAlquiler build() {
        return new ComandoAlquiler(id, cliente, pelicula);
    }
}
