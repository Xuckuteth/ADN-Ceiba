package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioCrearPelicula {

    private static final String EL_ID_DE_LA_PELICULA_YA_EXISTE = "El ID de la película ya existe en el sistema";
    private static final String FORMATO_INVALIDO = "El formato ingresado no es válido intente: DVD o Blue-ray ";
    private static final String FORMATO_DVD = "DVD";
    private static final String FORMATO_BLUERAY = "Blue-ray";

    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public Long ejecutar(Pelicula pelicula) {
        validarExistenciaPreviaPorId(pelicula);
        validarFormatoExistente(pelicula);
        return this.repositorioPelicula.crear(pelicula);
    }

    private void validarExistenciaPreviaPorId(Pelicula pelicula) {
        boolean existe = this.repositorioPelicula.existePorId(pelicula.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ID_DE_LA_PELICULA_YA_EXISTE);
        }
    }

    private void validarFormatoExistente(Pelicula pelicula){
        if (!pelicula.getFormato().equals(FORMATO_DVD) && !pelicula.getFormato().equals(FORMATO_BLUERAY)){
            throw new ExcepcionValorInvalido(FORMATO_INVALIDO + pelicula.getFormato());
        }
    }
}
