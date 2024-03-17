package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryClients extends JpaRepository<Clients, Long> {

}

