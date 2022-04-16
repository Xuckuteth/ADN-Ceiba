package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;


@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) {
        return new Alquiler(
                comandoAlquiler.getId(),
                comandoAlquiler.getCliente(),
                comandoAlquiler.getPelicula()
        );
    }

}
