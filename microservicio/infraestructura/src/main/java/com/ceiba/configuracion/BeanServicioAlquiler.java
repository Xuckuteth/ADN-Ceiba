package com.ceiba.configuracion;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.alquiler.servicio.ServicioEliminarAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioAlquiler {

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioCrearAlquiler(repositorioAlquiler);
    }

    @Bean
    public ServicioEliminarAlquiler servicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioEliminarAlquiler(repositorioAlquiler);
    }

    @Bean
    public ServicioActualizarAlquiler servicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioActualizarAlquiler(repositorioAlquiler);
    }


}
