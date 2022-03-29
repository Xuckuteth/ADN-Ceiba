package com.ceiba.pelicula.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pelicula {

    public static final String FORMATO_BLUERAY = "Blue-ray";
    public static final String FORMATO_DVD = "DVD";
    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA = "Se debe ingresar el nombre de la película";
    public static final String SE_DEBE_INGRESAR_EL_FORMATO_DE_LA_PELICULA = "Se debe ingresar el formato de la película: ==> Blue-ray <== o ==> DVD <==";


    private Long id;
    private String nombre;
    private String formato;

    public Pelicula(){}

    public Pelicula(Long id, String nombre, String formato) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_PELICULA);
        validarObligatorio(formato, SE_DEBE_INGRESAR_EL_FORMATO_DE_LA_PELICULA);

        this.id = id;
        this.nombre = nombre;
        this.formato = formato;
    }
}
