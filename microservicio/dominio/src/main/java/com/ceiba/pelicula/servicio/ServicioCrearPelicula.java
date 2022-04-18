package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioCrearPelicula {

    private static final String EL_NOMBRE_DE_LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA = "El nombre de la película ya existe en el sistema";
    private static final String FORMATO_INVALIDO = "El formato ingresado no es válido intente: DVD o Blue-ray ";
    private static final String FORMATO_DVD = "DVD";
    private static final String FORMATO_BLUERAY = "Blue-ray";

    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public Long ejecutar(Pelicula pelicula) {
        validarExistenciaPrevia(pelicula);
        validarFormatoExistente(pelicula);
        return this.repositorioPelicula.crear(pelicula);
    }

    private void validarExistenciaPrevia(Pelicula pelicula) {
        boolean existe = this.repositorioPelicula.existe(pelicula.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_DE_LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


    private void validarFormatoExistente(Pelicula pelicula){
        if (!pelicula.getFormato().equals(FORMATO_DVD) && !pelicula.getFormato().equals(FORMATO_BLUERAY)){
            throw new ExcepcionValorInvalido(FORMATO_INVALIDO + pelicula.getFormato());
        }
    }
}
