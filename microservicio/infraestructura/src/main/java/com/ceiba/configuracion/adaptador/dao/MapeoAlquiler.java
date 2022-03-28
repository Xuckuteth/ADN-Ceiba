package com.ceiba.configuracion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long cliente = resultSet.getLong("cliente");
        Long pelicula = resultSet.getLong("pelicula");
        LocalDate fechaAlquiler = extraerLocalDate(resultSet, "fecha_alquiler");
        LocalDate fechaDevolucion = extraerLocalDate(resultSet, "fecha_devolucion");
        String valor = resultSet.getString("valor");

        return new DtoAlquiler(id, cliente, pelicula, fechaAlquiler, fechaDevolucion, valor);
    }
}
