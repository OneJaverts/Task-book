package com.maslov.service;

import com.maslov.entity.Role;
import com.maslov.entity.User;
import com.maslov.repository.RoleRepository;
import com.maslov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void save(User user) {

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userRepository.save(user);
        System.out.println("Пользователь сохранен");
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
