package com.ceiba.configuracion;

import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.ServicioCrearPelicula;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPelicula {

    @Bean
    public ServicioCrearPelicula servicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        return new ServicioCrearPelicula(repositorioPelicula);
    }

    @Bean
    public ServicioEliminarPelicula servicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
        return new ServicioEliminarPelicula(repositorioPelicula);
    }

}
