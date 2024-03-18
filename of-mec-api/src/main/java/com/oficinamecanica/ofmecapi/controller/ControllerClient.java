package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.dao.ClientDAO;
import com.oficinamecanica.ofmecapi.model.*;
import com.oficinamecanica.ofmecapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerClient {

    private ClientDAO clientDAO;

    @Autowired
    public ControllerClient(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Autowired
    private ClientServiceService clientServiceRepository;

    // Retorna todas as client com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/client")
    public List<Client> getClients() {
        return clientServiceRepository.getClients();
    }

    // Retorna uma única client conforme o atributo id JDBCTemplate
    @GetMapping("/client/like/{like}")
    public List<Client> getServiceById(@PathVariable String like) {
        return clientServiceRepository.getClientsByLike(like);
    }

    // Retorna todas as client de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/client/{clientId}")
    public List<Client> getClientsByClientId(@PathVariable int clientId) {
        return clientServiceRepository.getClientsByClientId(clientId);
    }

    // Método para lidar com solicitações de inserção de Client
    @PostMapping("/client/insert")
    public String insertClient(@RequestBody Client clientInsert) {
        clientDAO.insertClient(clientInsert);
        return "redirect:/client"; // redireciona para a página de listagem de Client
    }

    // Método para lidar com solicitações de atualização de Client
    @PutMapping("/client/update/{id}")
    public String updateClient(@PathVariable int id, @RequestBody Client clientUpdate) {
        clientUpdate.setClientId(id);
        clientDAO.updateClient(clientUpdate);
        return "redirect:/client";
    }

    // Método para lidar com solicitações de exclusão de Client
    @DeleteMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientDAO.deleteClient(id);
        return "redirect:/client"; // redireciona para a página de listagem de Client
    }

}
