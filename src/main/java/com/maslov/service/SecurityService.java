package com.maslov.service;

import com.maslov.entity.User;

public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(User user);
}
