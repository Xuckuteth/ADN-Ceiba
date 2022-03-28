package com.ceiba.alquiler.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;

import java.time.LocalDate;

public class ServicioCrearAlquiler {

    private static final String EL_ALQUILER_YA_EXISTE_EN_EL_SISTEMA = "El alquiler ya existe en el sistema";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public Long ejecutar(Alquiler alquiler) {
        validarExistenciaPrevia(alquiler);
        return this.repositorioAlquiler.crear(alquiler);
    }

    private void validarExistenciaPrevia(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existePorId(alquiler.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ALQUILER_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
