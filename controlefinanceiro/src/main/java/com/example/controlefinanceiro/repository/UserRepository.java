package com.example.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.controlefinanceiro.model.User;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
