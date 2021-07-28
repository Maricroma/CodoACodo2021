package com.example.codoacodofinal.dao;

import com.example.codoacodofinal.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    public Role findByName(String name);
}
