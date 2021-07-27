package com.example.codoacodofinal.dao;

import com.example.codoacodofinal.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {

}
