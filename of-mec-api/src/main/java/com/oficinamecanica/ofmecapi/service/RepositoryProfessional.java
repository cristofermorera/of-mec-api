package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Clients;
import com.oficinamecanica.ofmecapi.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProfessional extends JpaRepository<Professional, Long> {

}

