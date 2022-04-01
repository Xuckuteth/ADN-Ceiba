package com.ceiba.alquiler.manejador;

import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.cliente.manejador.ManejadorActualizarCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.alquiler.servicio.ServicioEliminarAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlquiler implements ManejadorComando<Long> {

    private final ServicioEliminarAlquiler servicioEliminarAlquiler;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private  final DaoAlquiler daoAlquiler;

    public ManejadorEliminarAlquiler(ServicioEliminarAlquiler servicioEliminarAlquiler, ManejadorActualizarCliente manejadorActualizarCliente, DaoAlquiler daoAlquiler) {
        this.servicioEliminarAlquiler = servicioEliminarAlquiler;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.daoAlquiler = daoAlquiler;
    }

    public void ejecutar(Long idAlquiler) {
        this.manejadorActualizarCliente.ejecutarModificar(this.daoAlquiler.consultarPorId(idAlquiler));
        this.servicioEliminarAlquiler.ejecutar(idAlquiler);
    }



}
