package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceLocationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceLocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertServiceLocation(ServiceLocation serviceLocation) {
        String sql = "INSERT INTO Service_location (cid,address,move_in_date,size,bedroom_num,occupant_num,zipcode) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, serviceLocation.getCId(), serviceLocation.getAddress(), serviceLocation.getMoveInDate(),
                serviceLocation.getSize(), serviceLocation.getBedroomNum(), serviceLocation.getOccupantNum(),
                serviceLocation.getZipcode());
        return true;
    }

    public int updateServiceLocation(ServiceLocation serviceLocation) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("UPDATE Service_location SET ");
        if (serviceLocation.getCId() != null) {
            sql.append("cid = ?, ");
            params.add(serviceLocation.getCId());
        }
        if (serviceLocation.getAddress() != null) {
            sql.append("address = ?, ");
            params.add(serviceLocation.getAddress());
        }
        if (serviceLocation.getMoveInDate() != null) {
            sql.append("move_in_date = ?, ");
            params.add(serviceLocation.getMoveInDate());
        }
        if (serviceLocation.getSize() != null) {
            sql.append("size = ?, ");
            params.add(serviceLocation.getSize());
        }
        if (serviceLocation.getBedroomNum() != null) {
            sql.append("bedroom_num = ?, ");
            params.add(serviceLocation.getBedroomNum());
        }
        if (serviceLocation.getOccupantNum() != null) {
            sql.append("occupant_num = ?, ");
            params.add(serviceLocation.getOccupantNum());
        }
        if (serviceLocation.getZipcode() != null) {
            sql.append("zipcode = ?, ");
            params.add(serviceLocation.getZipcode());
        }
        sql.deleteCharAt(sql.length() - 2);
        sql.append("WHERE sid = ?");
        params.add(serviceLocation.getSId());
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    public ServiceLocation getServiceLocationBySId(Integer sId) {
        String sql = "SELECT * " +
                "FROM Service_location " +
                "WHERE sid = ?";
        List<ServiceLocation> serviceLocations = jdbcTemplate.query(sql, new Object[]{sId}, (rs, rowNum) ->
                new ServiceLocation(
                        rs.getInt("sid"),
                        rs.getInt("cid"),
                        rs.getString("address"),
                        rs.getDate("move_in_date").toLocalDate(),
                        rs.getInt("size"),
                        rs.getInt("bedroom_num"),
                        rs.getInt("occupant_num"),
                        rs.getString("zipcode")
                ));
        if (serviceLocations.isEmpty()) {
            return null;
        } else {
            return serviceLocations.get(0);
        }
    }

    public List<ServiceLocation> listByCustomerId(Integer customerId) {
        String sql = "SELECT * " +
                "FROM Service_location " +
                "WHERE cid = ?";
        return jdbcTemplate.query(sql, new Object[]{customerId}, (rs, rowNum) ->
                new ServiceLocation(
                        rs.getInt("sid"),
                        rs.getInt("cid"),
                        rs.getString("address"),
                        rs.getDate("move_in_date").toLocalDate(),
                        rs.getInt("size"),
                        rs.getInt("bedroom_num"),
                        rs.getInt("occupant_num"),
                        rs.getString("zipcode")
                ));
    }

    public boolean deleteServiceLocation(Integer sId) {
        String sql = "DELETE FROM Service_location " +
                "WHERE sid = ?";
        jdbcTemplate.update(sql, sId);
        return true;
    }

    public String getZipcodeBySid(Integer sId) {
        String sql = "SELECT zipcode " +
                "FROM Service_location " +
                "WHERE sid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{sId}, String.class);
    }
}
