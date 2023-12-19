package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeviceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeviceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Device getDeviceById(Integer deviceId) {
        String sql = "SELECT * FROM device WHERE did = ?";
        List<Device> devices = jdbcTemplate.query(sql, new Object[]{deviceId}, (rs, rowNum) ->
                new Device(
                        rs.getInt("did"),
                        rs.getString("description"),
                        rs.getInt("tid"),
                        rs.getInt("sid")
                ));
        if (devices.isEmpty()) {
            return null;
        } else {
            return devices.get(0);
        }
    }

    public List<Device> listDeviceBySid(Integer sid) {
        String sql = "SELECT * FROM device WHERE sid = ?";
        return jdbcTemplate.query(sql, new Object[]{sid}, (rs, rowNum) ->
                new Device(
                        rs.getInt("did"),
                        rs.getString("description"),
                        rs.getInt("tid"),
                        rs.getInt("sid")
                ));
    }

    public List<Device> listDeviceByTid(Integer tid) {
        String sql = "SELECT * FROM device WHERE tid = ?";
        return jdbcTemplate.query(sql, new Object[]{tid}, (rs, rowNum) ->
                new Device(
                        rs.getInt("did"),
                        rs.getString("description"),
                        rs.getInt("tid"),
                        rs.getInt("sid")
                ));
    }

    public int updateDevice(Device device) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("UPDATE Device SET ");
        if (device.getDescription() != null) {
            sql.append("description = ?, ");
            params.add(device.getDescription());
        }
        if (device.getTid() != null) {
            sql.append("tid = ?, ");
            params.add(device.getTid());
        }
        if (device.getSid() != null) {
            sql.append("sid = ?, ");
            params.add(device.getSid());
        }
        sql.deleteCharAt(sql.length() - 2);
        sql.append("WHERE did = ?");
        params.add(device.getDid());
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    public int insertDevice(Device device) {
        String sql = "INSERT INTO device (description, tid, sid) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, device.getDescription(), device.getTid(), device.getSid());
    }

    public int deleteDeviceById(Integer deviceId) {
        String sql = "DELETE FROM device WHERE did = ?";
        return jdbcTemplate.update(sql, deviceId);
    }

    public int deleteDeviceBySid(Integer sid) {
        String sql = "DELETE FROM device WHERE sid = ?";
        return jdbcTemplate.update(sql, sid);
    }
}
