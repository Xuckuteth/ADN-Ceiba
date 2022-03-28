package com.ceiba.alquiler.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.fabrica.FabricaAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;

import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAlquier implements ManejadorComando<ComandoAlquiler> {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioActualizarAlquiler servicioActualizarAlquiler;

    public ManejadorActualizarAlquier(FabricaAlquiler fabricaAlquiler, ServicioActualizarAlquiler servicioActualizarAlquiler) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioActualizarAlquiler = servicioActualizarAlquiler;
    }

    public void ejecutar(ComandoAlquiler comandoAlquiler) {
        Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler);
        this.servicioActualizarAlquiler.ejecutar(alquiler);
    }
}
