package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductServiceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getProduct() {
        String sql = "SELECT * FROM products";

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToProduct(rs));
    }

    public List<Product> getProductByLike(String like) {
        try {
            String sql = "SELECT * FROM products WHERE description LIKE CONCAT('%', ?, '%') OR marca LIKE CONCAT('%', ?, '%') OR fornecedor LIKE CONCAT('%', ?, '%')";
            List<Product> product = jdbcTemplate.query(sql, new Object[]{like, like, like}, (rs, rowNum) -> mapToProduct(rs));
            return product != null ? product : Collections.emptyList();
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<Product> getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> mapToProduct(rs));
    }

    private Product mapToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setDescription(rs.getString("description"));
        product.setMarca(rs.getString("marca"));
        product.setFornecedor(rs.getString("fornecedor"));
        product.setValueCust(rs.getInt("value_cust"));
        product.setValueMargem(rs.getInt("value_Margem"));
        product.setValueVenda(rs.getInt("value_venda"));
        product.setValidation(rs.getString("validation"));
        product.setValue(rs.getInt("value"));
        product.setStock(rs.getInt("stock"));

        return product;
    }

}

