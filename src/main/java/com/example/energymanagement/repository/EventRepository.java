package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EventRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> listEventByDate(LocalDate startDate, LocalDate endDate, Integer did) {
        String sql = "SELECT * FROM Event WHERE did = ? AND time >= ? AND time <= ?";
        return jdbcTemplate.query(sql, new Object[]{did, startDate, endDate}, (rs, rowNum) ->
                new Event(
                        rs.getInt("eid"),
                        rs.getInt("did"),
                        rs.getTimestamp("time").toLocalDateTime(),
                        rs.getString("event_type"),
                        rs.getDouble("value")
                ));
    }
}
