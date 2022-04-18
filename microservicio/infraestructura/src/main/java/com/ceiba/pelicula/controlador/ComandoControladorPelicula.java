package com.ceiba.pelicula.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.manejador.ManejadorCrearPelicula;
import com.ceiba.pelicula.manejador.ManejadorEliminarPelicula;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
@Api(tags = { "Controlador comando pelicula"})
public class ComandoControladorPelicula {

    private final ManejadorCrearPelicula manejadorCrearPelicula;
    private final ManejadorEliminarPelicula manejadorEliminarPelicula;

    @Autowired
    public ComandoControladorPelicula(ManejadorCrearPelicula manejadorCrearPelicula,
                                     ManejadorEliminarPelicula manejadorEliminarPelicula) {
        this.manejadorCrearPelicula = manejadorCrearPelicula;
        this.manejadorEliminarPelicula = manejadorEliminarPelicula;
    }

    @PostMapping
    @ApiOperation("Crear Pelicula")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPelicula comandoPelicula) {
        return manejadorCrearPelicula.ejecutar(comandoPelicula);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar pelicula")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPelicula.ejecutar(id);
    }

}
