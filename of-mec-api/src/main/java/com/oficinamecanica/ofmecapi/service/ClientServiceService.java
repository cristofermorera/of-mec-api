package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class ClientServiceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClients() {
        String sql = "SELECT * FROM clients";

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToClient(rs));
    }

    public List<Client> getClientsByLike(String like) {
        try {
            String sql = "SELECT * FROM clients WHERE name_client LIKE CONCAT('%', ?, '%') OR nickname LIKE CONCAT('%', ?, '%') OR email_client LIKE CONCAT('%', ?, '%')";
            List<Client> clients = jdbcTemplate.query(sql, new Object[]{like, like, like}, (rs, rowNum) -> mapToClient(rs));
            return clients != null ? clients : Collections.emptyList();
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<Client> getClientsByClientId(int clientId) {
        String sql = "SELECT * FROM clients WHERE id_client = ?";

        return jdbcTemplate.query(sql, new Object[]{clientId}, (rs, rowNum) -> mapToClient(rs));
    }

    private Client mapToClient(ResultSet rs) throws SQLException {

        Client client = new Client();
        client.setClientId(rs.getInt("id_client"));
        client.setClientName(rs.getString("name_client"));
        client.setClientLastName(rs.getString("lastname"));
        client.setClientBirth(rs.getString("birth"));
        client.setClientType(rs.getString("type"));
        client.setClientNickname(rs.getString("nickname"));
        client.setClientPhone(rs.getLong("fone"));
        client.setClientEmail(rs.getString("email_client"));
        client.setClientCPF(rs.getLong("cpf"));
        client.setClientCEP(rs.getInt("cep"));
        client.setClientAddress(rs.getString("address"));
        client.setClientAddressNumber(rs.getLong("number_address"));

        return client;
    }
}

