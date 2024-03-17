package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducts extends JpaRepository<Products, Long> {

}
