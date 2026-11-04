package com.example.controlefinanceiro.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.controlefinanceiro.dto.request.UserAtualizacaoRequest;
import com.example.controlefinanceiro.dto.request.UserRequest;
import com.example.controlefinanceiro.exception.EmailAlreadyExistException;
import com.example.controlefinanceiro.exception.UserNotFoundException;
import com.example.controlefinanceiro.model.User;
import com.example.controlefinanceiro.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User salvarUser(UserRequest c) {
        if (userRepository.existsByEmail(c.email())) {
            throw new EmailAlreadyExistException("Email já cadastrado");
        }

        String senhaCriptografada = passwordEncoder.encode(c.password());
    

    User user = new User();
    user.setName(c.name());
    user.setEmail(c.email());
    user.setPassword(senhaCriptografada);
    
    return userRepository.save(user);

    }

    @Transactional (readOnly = true)
    public User buscarUserPorID(UUID ID) {
        return userRepository.findById(ID)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

    }

    @Transactional (readOnly = true)
    public User buscarUserPorEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    @Transactional (readOnly = true)
    public List<User> buscarTodosUsers() {
        return userRepository.findAll();
    }


    @Transactional
    public User atualizarUser(UUID ID, UserAtualizacaoRequest c) {
        User user = buscarUserPorID(ID);
        user.setName(c.name());
        String senhaCriptografada = passwordEncoder.encode(c.password());
        user.setPassword(senhaCriptografada);
        return userRepository.save(user);
    }


    @Transactional
    public void deletarUser(UUID ID) {
        User user = buscarUserPorID(ID);
        userRepository.delete(user);

        
    }

}
