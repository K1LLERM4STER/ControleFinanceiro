package com.example.controlefinanceiro.service;

import com.example.controlefinanceiro.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    

}
