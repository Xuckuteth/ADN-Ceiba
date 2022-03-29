package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import lombok.Getter;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Alquiler {

    public static final int VALOR_BLUERAY = 12;
    public static final int VALOR_DVD = 8;
    public static final double PRIMER_INCREMENTO = .2;
    public static final double SEGUNDO_INCREMENTO = .5;
    public static final int DIAS_ESTANDAR= 10;
    public static final int DIAS_INCUMPLIMIENTO = 4;

    private static final String SE_DEBE_INGRESAR_EL_ID = "Se debe ingresar el ID";
    private static final String SE_DEBE_INGRESAR_UN_CLIENTE = "Se debe ingresar un cliente";
    private static final String SE_DEBE_INGRESAR_UNA_PELICULA = "Se debe ingresar una pelicula";


    private Long id;
    private Cliente cliente;
    private Pelicula pelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private String valor;


    public Alquiler(Long id, Cliente cliente, Pelicula pelicula, LocalDate fechaAlquiler, LocalDate fechaDevolucion, String valor) {
        validarObligatorio(cliente, SE_DEBE_INGRESAR_UN_CLIENTE);
        validarObligatorio(pelicula, SE_DEBE_INGRESAR_UNA_PELICULA);
        this.id = id;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.valor= valor;
    }

}
