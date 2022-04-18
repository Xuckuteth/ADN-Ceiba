package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import lombok.Getter;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Alquiler {

    public static final int VALOR_BLUERAY = 12;
    public static final int VALOR_DVD = 8;
    public static final double PRIMER_INCREMENTO = 0.2;
    public static final double SEGUNDO_INCREMENTO = 0.5;
    public static final int DIAS_ESTANDAR= 10;
    public static final int DIAS_INCUMPLIMIENTO = 4;

    private static final String SE_DEBE_INGRESAR_EL_ID = "Se debe ingresar el ID";
    private static final String SE_DEBE_INGRESAR_UN_CLIENTE = "Se debe ingresar un cliente";
    private static final String SE_DEBE_INGRESAR_UNA_PELICULA = "Se debe ingresar una pelicula";
    private static final String UN_CLIENTE_VETADO_NO_PUEDE_ALQUILAR = "El cliente se encuentra vetado y por lo tanto no puede crear un alquiler";


    private Long id;
    private Cliente cliente;
    private Pelicula pelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private String valor;


    public Alquiler(Long id, Cliente cliente, Pelicula pelicula) {
        validarObligatorio(cliente, SE_DEBE_INGRESAR_UN_CLIENTE);
        validarObligatorio(pelicula, SE_DEBE_INGRESAR_UNA_PELICULA);
        validarIgual(cliente.getEstado(), Cliente.VETATO, UN_CLIENTE_VETADO_NO_PUEDE_ALQUILAR);
        this.id = id;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaAlquiler = LocalDate.now();
        this.fechaDevolucion = calcularFechaDeDevolucion(cliente);
        this.valor= calcularValorAlquiler(cliente, pelicula);
    }

    public LocalDate calcularFechaDeDevolucion(Cliente cliente){
        int numeroDias = 0;
        LocalDate fecha = LocalDate.now();

        if (cliente.getEstado().equals(Cliente.ESTANDAR)) {
            numeroDias = Alquiler.DIAS_ESTANDAR;
        } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO)){
            numeroDias = Alquiler.DIAS_INCUMPLIMIENTO;
        } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO_X2)){
            numeroDias = Alquiler.DIAS_INCUMPLIMIENTO;
        }

        while (numeroDias != 0) {
            if (!fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY) && !fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                fecha = fecha.plusDays(1);
                numeroDias -= 1;
            } else {
                fecha = fecha.plusDays(1);
            }
        }
        return fecha;
    }

    public String calcularValorAlquiler(Cliente cliente, Pelicula pelicula){
        double valorAlquiler = 0;
        if (cliente.getEstado().equals(Cliente.ESTANDAR)){
            if (pelicula.getFormato().equals(Pelicula.FORMATO_DVD)){
                valorAlquiler = Alquiler.VALOR_DVD;
            } else if (pelicula.getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valorAlquiler = Alquiler.VALOR_BLUERAY;
            }
        } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO)){
            if (pelicula.getFormato().equals(Pelicula.FORMATO_DVD)){
                valorAlquiler = Alquiler.VALOR_DVD + (Alquiler.VALOR_DVD * Alquiler.PRIMER_INCREMENTO);
            } else if (pelicula.getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valorAlquiler = Alquiler.VALOR_BLUERAY + (Alquiler.VALOR_BLUERAY * Alquiler.PRIMER_INCREMENTO);
            }
        } else if (cliente.getEstado().equals(Cliente.INCUMPLIMIENTO_X2)){
            if (pelicula.getFormato().equals(Pelicula.FORMATO_DVD)){
                valorAlquiler = Alquiler.VALOR_DVD + (Alquiler.VALOR_DVD * Alquiler.SEGUNDO_INCREMENTO);
            } else if (pelicula.getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valorAlquiler = Alquiler.VALOR_BLUERAY + (Alquiler.VALOR_BLUERAY * Alquiler.SEGUNDO_INCREMENTO);
            }
        }

        return String.valueOf(valorAlquiler + " USD");
    }
}
