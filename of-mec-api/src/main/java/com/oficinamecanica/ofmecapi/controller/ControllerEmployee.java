package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.Employee;
import com.oficinamecanica.ofmecapi.service.EmployeeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerEmployee {

    @Autowired
    private EmployeeServiceService employeeServiceRepository;

    // Retorna todas as Employee com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeServiceRepository.getEmployee();
    }

    // Retorna uma única Employee conforme o atributo id JDBCTemplate
    @GetMapping("/employeeLike/{like}")
    public List<Employee> getEmployeeServiceById(@PathVariable String like) {
        return employeeServiceRepository.getEmployeeByLike(like);
    }

    // Retorna todas as Employee de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/employeeId/{id}")
    public List<Employee> getEmployeetById(@PathVariable int id) {
        return employeeServiceRepository.getEmployeeById(id);
    }

}
