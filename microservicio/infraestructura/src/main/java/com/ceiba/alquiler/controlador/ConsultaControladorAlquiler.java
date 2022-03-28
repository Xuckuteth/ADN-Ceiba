package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarAlquileres;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alquileres")
@Api(tags={"Controlador consulta alquiler"})
public class ConsultaControladorAlquiler {
    private final ManejadorListarAlquileres manejadorListarAlquileres;

    public ConsultaControladorAlquiler(ManejadorListarAlquileres manejadorListarAlquileres) {
        this.manejadorListarAlquileres = manejadorListarAlquileres;
    }

    @GetMapping
    @ApiOperation("Listar alquileres")
    public List<DtoAlquiler> listar() {
        return this.manejadorListarAlquileres.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar alquiler")
    public DtoAlquiler consultarPorId (@PathVariable Long id) {
        return this.manejadorListarAlquileres.consultarPorId(id);
    }
}
