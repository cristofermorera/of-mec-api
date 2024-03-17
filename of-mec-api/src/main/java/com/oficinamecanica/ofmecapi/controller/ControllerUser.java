package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.User;
import com.oficinamecanica.ofmecapi.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerUser {

    @Autowired
    private UserServiceService userServiceRepository;

    // Retorna todas as user com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/user")
    public List<User> getUser() {
        return userServiceRepository.getUser();
    }

    // Retorna uma única user conforme o atributo Email e Password LOGIN JDBCTemplate
    @GetMapping("/user/{email}/{password}")
    public boolean getUserLogin(@PathVariable String email, @PathVariable String password) {
        return userServiceRepository.getUserLogin(email, password);
    }

    // Retorna uma única user conforme o atributo id JDBCTemplate
    @GetMapping("/userLike/{like}")
    public List<User> getUserById(@PathVariable String like) {
        return userServiceRepository.getUserByLike(like);
    }

    // Retorna todas as user de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/userId/{id}")
    public List<User> getUserById(@PathVariable int id) {
        return userServiceRepository.getUserById(id);
    }

}
