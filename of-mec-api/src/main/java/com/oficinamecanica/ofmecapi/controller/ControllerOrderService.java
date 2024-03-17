package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.*;
import com.oficinamecanica.ofmecapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerOrderService {

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
    @GetMapping("/osClient/{clientId}")
    public List<OrderService> getOrderClientsByClientId(@PathVariable int clientId) {
        return orderServiceRepository.getOrderClientsByClientId(clientId);
    }

}
