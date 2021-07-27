package com.example.codoacodofinal.dao;

import com.example.codoacodofinal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
