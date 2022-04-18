package com.ceiba.alquiler.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.manejador.ManejadorCrearAlquiler;
import com.ceiba.alquiler.manejador.ManejadorEliminarAlquiler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquileres")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {
    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
    private final ManejadorEliminarAlquiler manejadorEliminarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler,
                                     ManejadorEliminarAlquiler manejadorEliminarAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
        this.manejadorEliminarAlquiler = manejadorEliminarAlquiler;
    }

    @PostMapping
    @ApiOperation("Crear Alquiler")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlquiler comandoAlquiler) {
        return manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Pagar alquiler")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarAlquiler.ejecutar(id);
    }

}
