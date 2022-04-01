package com.ceiba.alquiler.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long id;
    private Long cliente;
    private Long pelicula;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private String valor;
}
