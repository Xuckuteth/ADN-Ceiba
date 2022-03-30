package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cliente {
    public static final String SE_DEBE_INGRESAR_EL_ID_DEL_CLIENTE = "Se debe ingresar el número de identificación del cliente";
    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
    public static final String SE_DEBE_INGRESAR_EL_ESTADO_DEL_CLIENTE = "Se debe ingresar el estado del cliente";
    public static final String ESTANDAR = "Estandar";
    public static final String INCUMPLIMIENTO = "Incumplimiento";
    public static final String INCUMPLIMIENTO_X2 = "Incumplimiento X2";
    public static final String VETATO = "Vetado";

    private Long id;
    private String nombre;
    private String estado;


    public Cliente(Long id, String nombre, String estado) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO_DEL_CLIENTE);

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Cliente(Long id, String estado){
        this.id = id;
        this.estado = estado;
    }

    public Cliente(){}
}
