package com.ceiba.pelicula.puerto.repositorio;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public interface RepositorioPelicula {

    /**
     * Permite crear una pelicula
     * @param pelicula
     * @return el id generado
     */
    Long crear(Pelicula pelicula);

    /**
     * Permite actualizar una pelicula
     * @param pelicula
     */
    void actualizar(Pelicula pelicula);

    /**
     * Permite eliminar una pelicula
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una pelicula con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe una pelicula con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
