package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Get all type names
     *
     * @return list of types
     */
    public List<Type> listAllTypeNames() {
        String sql = "SELECT distinct tname FROM type";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Type type = new Type();
            type.setName(resultSet.getString("tname"));
            return type;
        });
    }

    /**
     * Get all models of a type
     *
     * @return list of types
     */
    public List<Type> listAllModel(String tname) {
        String sql = "SELECT tid, model_number FROM type where tname = ?";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Type type = new Type();
            type.settId(resultSet.getInt("tid"));
            type.setModelNumber(resultSet.getString("model_number"));
            return type;
        }, tname);
    }

    /**
     * Get all types
     *
     * @return list of types
     */
    public List<Type> listAllTypes() {
        String sql = "SELECT * FROM type";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Type type = new Type();
            type.settId(resultSet.getInt("tid"));
            type.setName(resultSet.getString("tname"));
            type.setModelNumber(resultSet.getString("model_number"));
            return type;
        });
    }

}
