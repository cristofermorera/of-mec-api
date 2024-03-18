package com.oficinamecanica.ofmecapi.controller;

import com.oficinamecanica.ofmecapi.model.Product;
import com.oficinamecanica.ofmecapi.dao.ProductDAO;
import com.oficinamecanica.ofmecapi.service.ProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerProduct {

    private ProductDAO productDAO;

    @Autowired
    public ControllerProduct(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    private ProductServiceService productServiceRepository;

    // Retorna todas as Product com o nome de cada cliente respectivo JDBCTemplate
    @GetMapping("/product")
    public List<Product> getProduct() {
        return productServiceRepository.getProduct();
    }

    // Retorna uma única Product conforme o atributo id JDBCTemplate
    @GetMapping("/product/like/{like}")
    public List<Product> getProductServiceById(@PathVariable String like) {
        return productServiceRepository.getProductByLike(like);
    }

    // Retorna todas as Product de um determinado cliente através do atributo clientId JDBCTemplate
    @GetMapping("/product/{id}")
    public List<Product> getProductById(@PathVariable int id) {
        return productServiceRepository.getProductById(id);
    }

    // Método para lidar com solicitações de inserção de produtos
    @PostMapping("/product/insert")
    public String inserirProduto(@RequestBody Product product) {
        productDAO.insertProduct(product);
        return "redirect:/product"; // redireciona para a página de listagem de produtos
    }

    // Método para lidar com solicitações de atualização de produtos
    @PutMapping("/product/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product productUpdate) {
        productUpdate.setId(id); // Garante que o ID do produto atualizado seja o mesmo do produto existente
        productDAO.updateProduct(productUpdate);
        return "redirect:/product"; // redireciona para a página de listagem de produtos
    }

    // Método para lidar com solicitações de exclusão de produtos
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.deleteProduct(id);
        return "redirect:/product"; // redireciona para a página de listagem de produtos
    }
}
