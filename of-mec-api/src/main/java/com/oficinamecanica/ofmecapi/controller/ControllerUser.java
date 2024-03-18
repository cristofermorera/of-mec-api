package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.dao.ProductDAO;
import com.oficinamecanica.ofmecapi.dao.UserDAO;
import com.oficinamecanica.ofmecapi.model.Product;
import com.oficinamecanica.ofmecapi.model.User;
import com.oficinamecanica.ofmecapi.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerUser {

    private UserDAO userDAO;

    @Autowired
    public ControllerUser(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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
    @GetMapping("/user/like/{like}")
    public List<User> getUserById(@PathVariable String like) {
        return userServiceRepository.getUserByLike(like);
    }

    // Retorna todas as user de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/user/{id}")
    public List<User> getUserById(@PathVariable int id) {
        return userServiceRepository.getUserById(id);
    }

    // Método para lidar com solicitações de inserção de User
    @PostMapping("/user/insert")
    public String inserirUser(@RequestBody User user) {
        userDAO.insertUser(user);
        return "redirect:/user"; // redireciona para a página de listagem de produtos
    }

    // Método para lidar com solicitações de atualização de User
    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User userUpdate) {
        userUpdate.setId(id); // Garante que o ID do User atualizado seja o mesmo do produto existente
        userDAO.updateUser(userUpdate);
        return "redirect:/user"; // redireciona para a página de listagem de User
    }

    // Método para lidar com solicitações de exclusão de User
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userDAO.deleteUser(id);
        return "redirect:/user"; // redireciona para a página de listagem de User
    }

}
