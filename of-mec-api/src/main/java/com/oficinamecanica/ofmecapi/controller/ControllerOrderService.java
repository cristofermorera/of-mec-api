package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.dao.OrderServiceDAO;
import com.oficinamecanica.ofmecapi.model.*;
import com.oficinamecanica.ofmecapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerOrderService {

    private OrderServiceDAO orderServiceDAO;

    @Autowired
    public ControllerOrderService(OrderServiceDAO orderServiceDAO) {
        this.orderServiceDAO = orderServiceDAO;
    }

    @Autowired
    private OrderServiceService orderServiceRepository;

    // Retorna todas as order_service com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/os")
    public List<OrderService> getOrderClients() {
        return orderServiceRepository.getOrderClients();
    }

    // Retorna uma unica order_service de acordo com o atributo id JDBCTemplate
    @GetMapping("/os/{id}")
    public OrderService getOrderServiceById(@PathVariable int id) {
        return orderServiceRepository.getOrderClientsById(id);
    }

    // Retorna todas as order_service de um determinado cliente atavez do atributo clientId JDBCTemplate
    @GetMapping("/os/client/{clientId}")
    public List<OrderService> getOrderClientsByClientId(@PathVariable int clientId) {
        return orderServiceRepository.getOrderClientsByClientId(clientId);
    }

    // Método para lidar com solicitações de inserção de Ordem de Serviços
    @PostMapping("/os/insert")
    public String insertOrderService(@RequestBody OrderService orderServiceInsert) {
        orderServiceDAO.insertOrderService(orderServiceInsert);
        return "redirect:/os"; // redireciona para a página de listagem de Ordem de Serviços
    }

    // Método para lidar com solicitações de atualização de Ordem de Serviços
    @PutMapping("/os/update/{id}")
    public String updateOrderService(@PathVariable long id, @RequestBody OrderService orderServiceUpdate) {
        orderServiceUpdate.setOrderId(id);
        orderServiceDAO.updateOrderService(orderServiceUpdate);
        return "redirect:/os";
    }

    // Método para lidar com solicitações de exclusão de Ordem de Serviços
    @DeleteMapping("/os/delete/{id}")
    public String deleteOrderService(@PathVariable int id) {
        orderServiceDAO.deleteOrderService(id);
        return "redirect:/os"; // redireciona para a página de listagem de Ordem de Serviços
    }

}
