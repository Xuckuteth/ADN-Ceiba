package com.ceiba.cliente.controlador;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador consulta cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;

    public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes) {
        this.manejadorListarClientes = manejadorListarClientes;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoCliente> listar() {
        return this.manejadorListarClientes.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Cliente")
    public DtoCliente consultarPorId (@PathVariable Long id) {
        return this.manejadorListarClientes.consultarPorId(id);
    }
}
