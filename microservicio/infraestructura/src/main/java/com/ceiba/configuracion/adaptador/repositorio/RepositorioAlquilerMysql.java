package com.ceiba.configuracion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alquiler", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="alquiler", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="alquiler", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alquiler alquiler) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", alquiler.getId());
        parameterSource.addValue("cliente", alquiler.getCliente().getId());
        parameterSource.addValue("pelicula", alquiler.getPelicula().getId());
        parameterSource.addValue("fechaAlquiler", alquiler.getFechaAlquiler());
        parameterSource.addValue("fechaDevolucion", alquiler.getFechaDevolucion());
        parameterSource.addValue("valor", alquiler.getValor());
        return Long.valueOf(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, parameterSource));
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
