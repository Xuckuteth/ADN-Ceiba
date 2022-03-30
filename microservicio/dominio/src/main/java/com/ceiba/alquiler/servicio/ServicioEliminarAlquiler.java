package com.ceiba.alquiler.servicio;


import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;


public class ServicioEliminarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;


    public ServicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void ejecutar(Long id) {

        this.repositorioAlquiler.eliminar(id);
    }


    /* private void actualizarEstadoCliente() {
        LocalDate fecha = LocalDate.now();
        if (alquiler.getFechaDevolucion().isBefore(fecha)){
            if (alquiler.getCliente().getEstado().equals(Cliente.ESTANDAR)){
                alquiler.getCliente().setEstado(Cliente.INCUMPLIMIENTO);
            } else if (alquiler.getCliente().getEstado().equals(Cliente.INCUMPLIMIENTO)){
                alquiler.getCliente().setEstado(Cliente.INCUMPLIMIENTO_X2);
            } else if (alquiler.getCliente().getEstado().equals(Cliente.INCUMPLIMIENTO_X2)) {
                alquiler.getCliente().setEstado(Cliente.VETATO);
            }
        }
    } */
}
