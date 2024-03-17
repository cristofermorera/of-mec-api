package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.*;
import com.oficinamecanica.ofmecapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    /*@Autowired
    private Repository repo;

    @Autowired
    private RepositoryClients repositoryClients;

    @Autowired
    private RepositoryProfessional repositoryProfessional;

    @Autowired
    private RepositoryProducts repositoryProducts;

    @Autowired
    private RepositoryOs repositoryOs;

    private RepositoryConsultOsCli repositoryConsultOsCli;

    @Autowired
    public void OrderController(RepositoryConsultOsCli repositoryConsultOsCli) {
        this.repositoryConsultOsCli = repositoryConsultOsCli;
    }

    @Autowired
    private OrderServiceService orderServiceRepository;

    // Retorna todas as order_service com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/oos")
    public List<OrderService> getOrderClients() {
        return orderServiceRepository.getOrderClients();
    }

    // Retorna uma unica order_service de acordo com o atributo id JDBCTemplate
    @GetMapping("/oos/{id}")
    public OrderService getOrderServiceById(@PathVariable int id) {
        return orderServiceRepository.getOrderClientsById(id);
    }

    // Retorna todas as order_service de um determinado cliente atavez do atributo clientId JDBCTemplate
    @GetMapping("/oosClient/{clientId}")
    public List<OrderService> getOrderClientsByClientId(@PathVariable int clientId) {
        return orderServiceRepository.getOrderClientsByClientId(clientId);
    }

    //Lists Data com JPA -----------------------------------
    @GetMapping("/users")
    public List<Persona> Users(){
        return repo.findAll();
    }

    @GetMapping("/clients")
    public List<Clients> Clients(){
        return repositoryClients.findAll();
    }

    @GetMapping("/employees")
    public List<Professional> Professional(){
        return repositoryProfessional.findAll();
    }

    @GetMapping("/products")
    public List<Products> Products(){
        return repositoryProducts.findAll();
    }

    @GetMapping("/order_service")
    public List<Os> Os(){
        return repositoryOs.findAll();
    }

    //Essa parte tras apenas os dados de uma tabela (order_service), via id de usuario com JPA
    @GetMapping("/ordersbyclients")
    public ResponseEntity<List<Os>> getOrdersByClientId(@RequestParam("clientId") Integer clientId) {
        return new ResponseEntity<List<Os>>(repositoryConsultOsCli.findOrderServiceByClientId(clientId), HttpStatus.OK);
    }

    //Insert Data -----------------------------------
    @PostMapping("/insert")
    public String post(@RequestBody Persona persona){
        repo.save(persona);
        return "Salvo";
    }

    //Update Data -----------------------------------
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Persona persona){
        Persona updatePersona = repo.findById(id).get();
        updatePersona.setNome(persona.getNome());
        updatePersona.setSexo(persona.getSexo());
        repo.save(updatePersona);
        return "Editado com Sucesso";
    }


    //Delete Data -----------------------------------
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona = repo.findById(id).get();
        repo.save(deletePersona);
        return "Deletado com Sucesso";
    }*/
}
