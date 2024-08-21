package com.cloud.senac.library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsuarioDto {

    private Long id;

    private String nome;

    private LocalDate dtNascimento;

    private int cpf;

    private String senha;

    private String email;

    private boolean adm;

}
