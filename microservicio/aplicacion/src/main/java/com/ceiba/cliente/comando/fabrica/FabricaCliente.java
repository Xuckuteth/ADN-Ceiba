package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(
            comandoCliente.getId(),
            comandoCliente.getNombre(),
            asignarEstado()
        );
    }


    public String asignarEstado(){
        return Cliente.ESTANDAR;
    }

}
