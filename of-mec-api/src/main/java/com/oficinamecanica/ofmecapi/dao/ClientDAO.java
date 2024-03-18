package com.oficinamecanica.ofmecapi.dao;

import com.oficinamecanica.ofmecapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ClientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Injeção do construtor para definir o DataSource
    public void ProdDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para inserir um cliente na tabela 'clients'
    public void insertClient(Client client) {
        String sql = "INSERT INTO clients (id_client, name_client, lastname, birth, type, nickname, fone, email_client, cpf, cep, address, number_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                client.getClientId(),
                client.getClientName(),
                client.getClientLastName(),
                client.getClientBirth(),
                client.getClientType(),
                client.getClientNickname(),
                client.getClientPhone(),
                client.getClientEmail(),
                client.getClientCPF(),
                client.getClientCEP(),
                client.getClientAddress(),
                client.getClientAddressNumber()
        );
    }

    // Método para atualizar um cliente na tabela 'clients'
    public void updateClient(Client client) {
        String sql = "UPDATE clients SET name_client=?, lastname=?, birth=?, type=?, nickname=?, fone=?, email_client=?, cpf=?, cep=?, address=?, number_address=? WHERE id_client=?";

        jdbcTemplate.update(sql,
                client.getClientName(),
                client.getClientLastName(),
                client.getClientBirth(),
                client.getClientType(),
                client.getClientNickname(),
                client.getClientPhone(),
                client.getClientEmail(),
                client.getClientCPF(),
                client.getClientCEP(),
                client.getClientAddress(),
                client.getClientAddressNumber(),
                client.getClientId()
        );
    }

    // Método para excluir um cliente na tabela 'clients' pelo ID
    public void deleteClient(int idClient) {
        String sql = "DELETE FROM clients WHERE id_client=?";
        jdbcTemplate.update(sql, idClient);
    }
}
