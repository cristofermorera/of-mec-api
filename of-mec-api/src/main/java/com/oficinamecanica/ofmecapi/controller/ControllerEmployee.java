package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.dao.EmployeeDAO;
import com.oficinamecanica.ofmecapi.model.Employee;
import com.oficinamecanica.ofmecapi.service.EmployeeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerEmployee {

    private EmployeeDAO employeeDAO;

    @Autowired
    public ControllerEmployee(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

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

    // Método para lidar com solicitações de inserção de employee
    @PostMapping("/employee/insert")
    public String insertEmployee(@RequestBody Employee employeeInsert) {
        employeeDAO.insertEmployee(employeeInsert);
        return "redirect:/employee"; // redireciona para a página de listagem de employee
    }

    // Método para lidar com solicitações de atualização de employee
    @PutMapping("/employee/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Employee employeeUpdate) {
        employeeUpdate.setId(id);
        employeeDAO.updateEmployee(employeeUpdate);
        return "redirect:/employee";
    }

    // Método para lidar com solicitações de exclusão de employee
    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDAO.deleteEmployee(id);
        return "redirect:/employee"; // redireciona para a página de listagem de employee
    }

}
