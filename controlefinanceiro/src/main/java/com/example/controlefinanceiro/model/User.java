package com.example.controlefinanceiro.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@Entity 
@ToString 
@Table (name = "users")
public class User {
  
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id 
    private UUID id;

    private String name;

    @Column (nullable = false, unique = true)
    private String email;

    @ToString.Exclude
    private String password;


}
