package com.maslov.service;

import com.maslov.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
