package com.oficinamecanica.ofmecapi.dao;

import com.oficinamecanica.ofmecapi.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class OrderServiceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Injeção do construtor para definir o DataSource
    public void ProdDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para inserir uma ordem de serviço na tabela 'order_service'
    public void insertOrderService(OrderService orderService) {
        String sql = "INSERT INTO order_service (id, date, forecast, value, car_id, car_name, car_chassi, car_year, car_plaque, car_km, client_id, product_id, product_quant, product_total, service_professional_Id, service_description, service_value, obs, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                orderService.getOrderId(),
                orderService.getOrderDate(),
                orderService.getOrderForecast(),
                orderService.getOrderValue(),
                orderService.getCarId(),
                orderService.getCarName(),
                orderService.getCarChassi(),
                orderService.getCarYear(),
                orderService.getCarPlaque(),
                orderService.getCarKm(),
                orderService.getClientId(),
                orderService.getProductId(),
                orderService.getProductQuant(),
                orderService.getProductTotal(),
                orderService.getServiceProfessionalId(),
                orderService.getServiceDescription(),
                orderService.getServiceValue(),
                orderService.getObs(),
                orderService.getDescription()
        );
    }

    // Método para atualizar uma ordem de serviço na tabela 'order_service'
    public void updateOrderService(OrderService orderService) {
        String sql = "UPDATE order_service SET date=?, forecast=?, value=?, car_id=?, car_name=?, car_chassi=?, car_year=?, car_plaque=?, car_km=?, client_id=?, product_id=?, product_quant=?, product_total=?, service_professional_Id=?, service_description=?, service_value=?, obs=?, description=? WHERE id=?";

        jdbcTemplate.update(sql,
                orderService.getOrderDate(),
                orderService.getOrderForecast(),
                orderService.getOrderValue(),
                orderService.getCarId(),
                orderService.getCarName(),
                orderService.getCarChassi(),
                orderService.getCarYear(),
                orderService.getCarPlaque(),
                orderService.getCarKm(),
                orderService.getClientId(),
                orderService.getProductId(),
                orderService.getProductQuant(),
                orderService.getProductTotal(),
                orderService.getServiceProfessionalId(),
                orderService.getServiceDescription(),
                orderService.getServiceValue(),
                orderService.getObs(),
                orderService.getDescription(),
                orderService.getOrderId()
        );
    }

    // Método para excluir uma ordem de serviço na tabela 'order_service' pelo ID
    public void deleteOrderService(int id) {
        String sql = "DELETE FROM order_service WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
