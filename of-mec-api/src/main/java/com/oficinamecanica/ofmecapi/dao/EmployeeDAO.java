package com.oficinamecanica.ofmecapi.dao;

import com.oficinamecanica.ofmecapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Injeção do construtor para definir o DataSource
    public void ProdDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para inserir um funcionário na tabela 'employee'
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, birth, first_date_contract, end_date_contract, fone, cep, nickname, email, cpf, address, number_address, state, obs) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                employee.getId(),
                employee.getName(),
                employee.getBirth(),
                employee.getFirstDateContract(),
                employee.getEndDateContract(),
                employee.getFone(),
                employee.getCep(),
                employee.getNickname(),
                employee.getEmail(),
                employee.getCpf(),
                employee.getAddress(),
                employee.getNumberAddress(),
                employee.getState(),
                employee.getObs()
        );
    }

    // Método para atualizar um funcionário na tabela 'employee'
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name=?, birth=?, first_date_contract=?, end_date_contract=?, fone=?, cep=?, nickname=?, email=?, cpf=?, address=?, number_address=?, state=?, obs=? WHERE id=?";

        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getBirth(),
                employee.getFirstDateContract(),
                employee.getEndDateContract(),
                employee.getFone(),
                employee.getCep(),
                employee.getNickname(),
                employee.getEmail(),
                employee.getCpf(),
                employee.getAddress(),
                employee.getNumberAddress(),
                employee.getState(),
                employee.getObs(),
                employee.getId()
        );
    }

    // Método para excluir um funcionário na tabela 'employee' pelo ID
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
