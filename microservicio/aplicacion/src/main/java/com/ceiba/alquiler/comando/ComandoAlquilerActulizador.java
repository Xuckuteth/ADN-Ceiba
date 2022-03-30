package com.ceiba.alquiler.comando;

import com.ceiba.cliente.modelo.entidad.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquilerActulizador {
        private Long id;
        private Cliente cliente;
}
