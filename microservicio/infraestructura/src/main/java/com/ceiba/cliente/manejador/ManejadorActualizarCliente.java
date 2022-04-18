package com.ceiba.cliente.manejador;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {

    private final ServicioActualizarCliente servicioActualizarCliente;
    private final DaoCliente daoCliente;

    public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente, DaoCliente daoCliente) {
        this.servicioActualizarCliente = servicioActualizarCliente;
        this.daoCliente = daoCliente;
    }

    /**
     *
     */
    public void ejecutar(ComandoCliente comandoCliente) {}

    public void ejecutarModificar(DtoAlquiler dtoAlquiler) {
        DtoCliente clienteDto = this.daoCliente.consultarPorId(dtoAlquiler.getCliente());
        this.servicioActualizarCliente.ejecutar(dtoAlquiler, clienteDto);
    }
}
