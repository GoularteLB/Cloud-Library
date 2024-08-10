package com.cloud.senac.library.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Usuario{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;
    @Column(nullable = false)
    private int cpf;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String email;
    private boolean adm;

}