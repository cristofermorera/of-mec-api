package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class UserServiceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUser() {
        String sql = "SELECT * FROM admin";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToUser(rs));
    }

    public boolean getUserLogin(String email, String password) {
        String sql = "SELECT COUNT(*) FROM admin WHERE email = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);
        return count > 0;
    }

    public List<User> getUserByLike(String like) {
        try {
            String sql = "SELECT * FROM admin WHERE name LIKE CONCAT('%', ?, '%') OR email LIKE CONCAT('%', ?, '%')";
            List<User> user = jdbcTemplate.query(sql, new Object[]{like, like, like}, (rs, rowNum) -> mapToUser(rs));
            return user != null ? user : Collections.emptyList();
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<User> getUserById(int id) {
        String sql = "SELECT * FROM admin WHERE id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> mapToUser(rs));
    }

    private User mapToUser(ResultSet rs) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getInt("role"));

        return user;
    }


}

