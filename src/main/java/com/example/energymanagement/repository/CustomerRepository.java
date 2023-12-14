package com.example.energymanagement.repository;

import com.example.energymanagement.model.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer getCustomerByEmail(String email) {
        String sql = "SELECT * " +
                "FROM customer " +
                "WHERE email = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
                new Customer(
                        rs.getInt("c_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("billing_address"),
                        rs.getString("phone"),
                        rs.getString("password")
                ));
    }

    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (name, email, billing_address, phone, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getBillingAddress(), customer.getPhone(), customer.getPassword());
    }

    public void updateCustomer(Customer customer) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("UPDATE customer SET ");

        if (customer.getName() != null) {
            sql.append("name = ?, ");
            params.add(customer.getName());
        }
        if (customer.getBillingAddress() != null) {
            sql.append("billing_address = ?, ");
            params.add(customer.getBillingAddress());
        }
        if (customer.getPhone() != null) {
            sql.append("phone = ?, ");
            params.add(customer.getPhone());
        }
        if (customer.getPassword() != null) {
            sql.append("password = ?, ");
            params.add(customer.getPassword());
        }

        sql = new StringBuilder(sql.substring(0, sql.length() - 2)); // remove last comma
        sql.append(" WHERE c_id = ?");
        params.add(customer.getcId());

        jdbcTemplate.update(sql.toString(), params.toArray());
    }

    public void deleteCustomer(Integer cId) {
        String sql = "DELETE FROM customer WHERE c_id = ?";
        jdbcTemplate.update(sql, cId);
    }

}
