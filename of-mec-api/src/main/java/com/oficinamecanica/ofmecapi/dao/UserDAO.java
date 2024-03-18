package com.oficinamecanica.ofmecapi.dao;

import com.oficinamecanica.ofmecapi.model.Client;
import com.oficinamecanica.ofmecapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Injeção do construtor para definir o DataSource
    public void ProdDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para inserir um admin na tabela 'User'
    public void insertUser(User user) {
        String sql = "INSERT INTO admin (name, email, password, role) " +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    // Método para atualizar um admin na tabela 'User'
    public void updateUser(User user) {
        String sql = "UPDATE admin SET name=?, email=?, password=?, role=? WHERE id=?";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    // Método para excluir um admin na tabela 'User' pelo ID
    public void deleteUser(int id) {
        String sql = "DELETE FROM admin WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
