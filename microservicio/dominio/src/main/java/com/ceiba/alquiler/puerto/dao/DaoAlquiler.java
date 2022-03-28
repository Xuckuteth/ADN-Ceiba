package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.util.List;

public interface DaoAlquiler {

    /**
     * Permite listar alquileres
     * @return los alquileres
     */
    List<DtoAlquiler> listar();

    DtoAlquiler consultarPorId(Long id);
}
