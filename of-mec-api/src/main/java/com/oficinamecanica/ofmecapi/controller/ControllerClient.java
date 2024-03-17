package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.*;
import com.oficinamecanica.ofmecapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerClient {

    @Autowired
    private ClientServiceService clientServiceRepository;

    // Retorna todas as client com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/client")
    public List<Client> getClients() {
        return clientServiceRepository.getClients();
    }

    // Retorna uma única client conforme o atributo id JDBCTemplate
    @GetMapping("/clientLike/{like}")
    public List<Client> getServiceById(@PathVariable String like) {
        return clientServiceRepository.getClientsByLike(like);
    }

    // Retorna todas as client de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/clientId/{clientId}")
    public List<Client> getClientsByClientId(@PathVariable int clientId) {
        return clientServiceRepository.getClientsByClientId(clientId);
    }

}
