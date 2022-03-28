package com.ceiba.configuracion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoPelicula implements RowMapper<DtoPelicula>, MapperResult {

    @Override
    public DtoPelicula mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String formato = resultSet.getString("formato");

        return new DtoPelicula(id,nombre, formato);
    }
}
