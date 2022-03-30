package com.ceiba.cliente.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

import java.time.LocalDate;
import java.util.List;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

    private final RepositorioCliente repositorioCliente;
    private final DaoCliente daoCliente;


    public ServicioActualizarCliente(RepositorioCliente repositorioCliente, DaoCliente daoCliente) {
        this.repositorioCliente = repositorioCliente;
        this.daoCliente = daoCliente;
    }

    public void ejecutar(DtoAlquiler dtoAlquiler, DtoCliente dtoCliente) {
        this.repositorioCliente.actualizar(actualizarEstadoCliente(dtoAlquiler, dtoCliente));
    }


    private Cliente actualizarEstadoCliente(DtoAlquiler alquiler, DtoCliente dtoCliente) {
        LocalDate fecha = LocalDate.now();
        Cliente cliente = new Cliente(dtoCliente.getId(), dtoCliente.getNombre(), dtoCliente.getEstado());
        if (alquiler.getFechaDevolucion().isBefore(fecha)){
            if (cliente.getEstado().equals(Cliente.ESTANDAR)){
                cliente.setEstado(Cliente.INCUMPLIMIENTO);
            } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO)){
                cliente.setEstado(Cliente.INCUMPLIMIENTO_X2);
            } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO_X2)) {
                cliente.setEstado(Cliente.VETATO);
            }
        }
        System.out.println(cliente);
        return cliente;
    }
}
