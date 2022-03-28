package com.ceiba.pelicula.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPelicula implements ManejadorComando<Long> {

    private final ServicioEliminarPelicula servicioEliminarPelicula;

    public ManejadorEliminarPelicula(ServicioEliminarPelicula servicioEliminarPelicula) {
        this.servicioEliminarPelicula = servicioEliminarPelicula;
    }

    public void ejecutar(Long idPelicula) {
        this.servicioEliminarPelicula.ejecutar(idPelicula);
    }
}
