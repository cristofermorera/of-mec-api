package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeServiceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getEmployee() {
        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToEmployee(rs));
    }

    public List<Employee> getEmployeeByLike(String like) {
        try {
            String sql = "SELECT * FROM employee WHERE name LIKE CONCAT('%', ?, '%') OR nickname LIKE CONCAT('%', ?, '%') OR email LIKE CONCAT('%', ?, '%')";
            List<Employee> employee = jdbcTemplate.query(sql, new Object[]{like, like, like}, (rs, rowNum) -> mapToEmployee(rs));
            return employee != null ? employee : Collections.emptyList();
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<Employee> getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> mapToEmployee(rs));
    }

    private Employee mapToEmployee(ResultSet rs) throws SQLException {

        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setBirth(rs.getString("birth"));
        employee.setFirstDateContract(rs.getString("first_date_contract"));
        employee.setEndDateContract(rs.getString("end_date_contract"));
        employee.setFone(rs.getLong("fone"));
        employee.setCep(rs.getInt("cep"));
        employee.setNickname(rs.getString("nickname"));
        employee.setEmail(rs.getString("email"));
        employee.setCpf(rs.getLong("cpf"));
        employee.setAddress(rs.getString("address"));
        employee.setNumberAddress(rs.getInt("number_address"));
        employee.setState(rs.getString("state"));
        employee.setObs(rs.getString("obs"));

        return employee;
    }
}

