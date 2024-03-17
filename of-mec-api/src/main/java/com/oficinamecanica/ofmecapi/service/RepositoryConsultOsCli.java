package com.oficinamecanica.ofmecapi.service;

import com.oficinamecanica.ofmecapi.model.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RepositoryConsultOsCli extends JpaRepository<Os, Long> {
    List<Os> findOrderServiceByClientId(Integer clientId);
}
