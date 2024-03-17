package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.Product;
import com.oficinamecanica.ofmecapi.service.ProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerProduct {

    @Autowired
    private ProductServiceService productServiceRepository;

    // Retorna todas as Product com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/product")
    public List<Product> getProduct() {
        return productServiceRepository.getProduct();
    }

    // Retorna uma única Product conforme o atributo id JDBCTemplate
    @GetMapping("/productLike/{like}")
    public List<Product> getProductServiceById(@PathVariable String like) {
        return productServiceRepository.getProductByLike(like);
    }

    // Retorna todas as Product de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/productId/{id}")
    public List<Product> getProductById(@PathVariable int id) {
        return productServiceRepository.getProductById(id);
    }

}
