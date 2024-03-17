package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Client;
import com.oficinamecanica.ofmecapi.model.Employee;
import com.oficinamecanica.ofmecapi.model.OrderService;
import com.oficinamecanica.ofmecapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderServiceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<OrderService> getOrderClients() {
        String sql = "SELECT o.*, c.*, e.*, p.* " +
                "FROM order_service o " +
                "JOIN clients c ON o.client_id = c.id_client " +
                "JOIN employee e ON o.service_professional_Id = e.id " +
                "JOIN products p ON o.product_id = p.id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToOrderClient(rs));
    }

    public OrderService getOrderClientsById(int id) {
        String sql = "SELECT o.*, c.*, e.*, p.* " +
                "FROM order_service o " +
                "JOIN clients c ON o.client_id = c.id_client " +
                "JOIN employee e ON o.service_professional_Id = e.id " +
                "JOIN products p ON o.product_id = p.id " +
                "WHERE o.id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> mapToOrderClient(rs));
    }

    public List<OrderService> getOrderClientsByClientId(int clientId) {
        String sql = "SELECT o.*, c.*, e.*, p.* " +
                "FROM order_service o " +
                "JOIN clients c ON o.client_id = c.id_client " +
                "JOIN employee e ON o.service_professional_Id = e.id " +
                "JOIN products p ON o.product_id = p.id " +
                "WHERE o.client_id = ?";

        return jdbcTemplate.query(sql, new Object[]{clientId}, (rs, rowNum) -> mapToOrderClient(rs));
    }

    private OrderService mapToOrderClient(ResultSet rs) throws SQLException {
        OrderService orderClient = new OrderService();
        orderClient.setOrderId(rs.getLong("id"));
        orderClient.setOrderDate(rs.getString("date"));
        orderClient.setOrderForecast(rs.getString("forecast"));
        orderClient.setOrderValue(rs.getInt("value"));
        orderClient.setCarId(rs.getInt("car_id"));
        orderClient.setCarName(rs.getString("car_name"));
        orderClient.setCarChassi(rs.getInt("car_chassi"));
        orderClient.setCarYear(rs.getInt("car_year"));
        orderClient.setCarPlaque(rs.getString("car_plaque"));
        orderClient.setCarKm(rs.getInt("car_km"));
        orderClient.setClientId(rs.getInt("client_id"));
        orderClient.setProductId(rs.getInt("product_id"));
        orderClient.setProductQuant(rs.getInt("product_quant"));
        orderClient.setProductTotal(rs.getInt("product_total"));
        orderClient.setServiceProfessionalId(rs.getInt("service_professional_Id"));
        orderClient.setServiceDescription(rs.getString("service_description"));
        orderClient.setServiceValue(rs.getInt("service_value"));
        orderClient.setObs(rs.getString("obs"));
        orderClient.setDescription(rs.getString("description"));

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

        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setDescription(rs.getString("description"));
        product.setMarca(rs.getString("marca"));
        product.setFornecedor(rs.getString("fornecedor"));
        product.setValueCust(rs.getInt("value_cust"));
        product.setValueMargem(rs.getInt("value_Margem"));
        product.setValueVenda(rs.getInt("value_venda"));
        product.setValidation(rs.getString("validation"));
        product.setValue(rs.getInt("value"));
        product.setStock(rs.getInt("stock"));

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

        orderClient.setClient(client);
        orderClient.setProduct(product);
        orderClient.setEmployee(employee);

        return orderClient;
    }
}

