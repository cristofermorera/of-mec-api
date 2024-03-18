package com.oficinamecanica.ofmecapi.dao;

import com.oficinamecanica.ofmecapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Injeção do construtor para definir o DataSource
    public void ProdDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para inserir um produto na tabela 'products'
    public void insertProduct(Product product) {
        String sql = "INSERT INTO products (id, description, marca, fornecedor, value_cust, value_Margem, value_venda, validation, value, stock) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                product.getId(),
                product.getDescription(),
                product.getMarca(),
                product.getFornecedor(),
                product.getValueCust(),
                product.getValueMargem(),
                product.getValueVenda(),
                product.getValidation(),
                product.getValue(),
                product.getStock()
        );
    }

    // Método para atualizar um produto na tabela 'products'
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET description=?, marca=?, fornecedor=?, value_cust=?, value_Margem=?, " +
                "value_venda=?, validation=?, value=?, stock=? WHERE id=?";

        jdbcTemplate.update(sql,
                product.getId(),
                product.getDescription(),
                product.getMarca(),
                product.getFornecedor(),
                product.getValueCust(),
                product.getValueMargem(),
                product.getValueVenda(),
                product.getValidation(),
                product.getValue(),
                product.getStock()
        );
    }

    // Método para excluir um produto na tabela 'products' pelo ID
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
