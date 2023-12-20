package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.EnergyPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EnergyPriceRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EnergyPriceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EnergyPrice> getEnergyPriceByDate(LocalDate date, String zipcode) {
        String sql = "SELECT * " +
                "FROM energy_price " +
                "WHERE (DATE(start_time) <= ? AND DATE(end_time) >= ?) " +
                "and zipcode = ?";
        return jdbcTemplate.query(sql, new Object[]{date, date, zipcode}, (rs, rowNum) ->
                new EnergyPrice(
                        rs.getInt("eid"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getTimestamp("end_time").toLocalDateTime(),
                        rs.getDouble("price"),
                        rs.getString("zipcode")
                ));
    }
}
