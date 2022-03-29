package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) {
        return new Alquiler(
                comandoAlquiler.getId(),
                comandoAlquiler.getCliente(),
                comandoAlquiler.getPelicula(),
                obtenerFechaAlquiler(),
                calcularFechaDeDevolución(comandoAlquiler),
                calcularValorAlquiler(comandoAlquiler)
        );
    }


    public LocalDate obtenerFechaAlquiler(){
        LocalDate fechaAlquiler = LocalDate.now();
        return fechaAlquiler;
    }

    public LocalDate calcularFechaDeDevolución(ComandoAlquiler comandoAlquiler){
        int numeroDias = 0;
        LocalDate fecha = obtenerFechaAlquiler();

        if (comandoAlquiler.getCliente().getEstado().equals(Cliente.ESTANDAR)) {
            numeroDias = Alquiler.DIAS_ESTANDAR;
        } else if (comandoAlquiler.getCliente().getEstado().equals(Cliente.INCUMPLIMIENTO)){
            numeroDias = Alquiler.DIAS_INCUMPLIMIENTO;
        }

        while (numeroDias != 0) {
            if (fecha.getDayOfWeek().toString() != "SUNDAY" && fecha.getDayOfWeek().toString() != "SATURDAY") {
                fecha = fecha.plusDays(1);
                numeroDias -= 1;
            } else {
                fecha = fecha.plusDays(1);
            }
        }
        return fecha;
    }

    public String calcularValorAlquiler(ComandoAlquiler comandoAlquiler){
        double valor = 0;
        if (comandoAlquiler.getCliente().getEstado().equals(Cliente.ESTANDAR)){
            if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_DVD)){
                valor = Alquiler.VALOR_DVD;
            } else if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valor = Alquiler.VALOR_BLUERAY;
            }
        } else if (comandoAlquiler.getCliente().getEstado().equals(Cliente.INCUMPLIMIENTO)){
            if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_DVD)){
                valor = Alquiler.VALOR_DVD + (Alquiler.VALOR_DVD * Alquiler.PRIMER_INCREMENTO);
            } else if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valor = Alquiler.VALOR_BLUERAY + (Alquiler.VALOR_BLUERAY * Alquiler.PRIMER_INCREMENTO);
            }
        } else if (comandoAlquiler.getCliente().getEstado().equals(Cliente.INCUMPLIMIENTO_X2)){
            if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_DVD)){
                valor = Alquiler.VALOR_DVD + (Alquiler.VALOR_DVD * Alquiler.SEGUNDO_INCREMENTO);
            } else if (comandoAlquiler.getPelicula().getFormato().equals(Pelicula.FORMATO_BLUERAY)){
                valor = Alquiler.VALOR_BLUERAY + (Alquiler.VALOR_BLUERAY * Alquiler.SEGUNDO_INCREMENTO);
            }
        }
        String valorString = String.valueOf(valor);
        return valorString;
    }

}
