package com.ceiba.cliente.manejador;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {

    private final FabricaCliente fabricaCliente;
    private final ServicioActualizarCliente servicioActualizarCliente;
    private final DaoCliente daoCliente;

    public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizarCliente servicioActualizarCliente, DaoCliente daoCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioActualizarCliente = servicioActualizarCliente;
        this.daoCliente = daoCliente;
    }

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        this.servicioActualizarCliente.ejecutar(null, null);
    }

    public void ejecutarModificar(DtoAlquiler dtoAlquiler) {
        DtoCliente clienteDto = this.daoCliente.consultarPorId(dtoAlquiler.getCliente());
        this.servicioActualizarCliente.ejecutar(dtoAlquiler, clienteDto);
    }
}
