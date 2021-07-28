package com.example.codoacodofinal.service;

import com.example.codoacodofinal.dao.RoleDao;
import com.example.codoacodofinal.dao.UserDao;
import com.example.codoacodofinal.domain.Client;
import com.example.codoacodofinal.domain.Role;
import com.example.codoacodofinal.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }

    public Role findRole(String name){
        return roleDao.findByName(name);
    }

    public Boolean existUsername(String username) {
        return (userDao.findByUsername(username)!=null)?Boolean.TRUE:Boolean.FALSE;
    }

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }
}
