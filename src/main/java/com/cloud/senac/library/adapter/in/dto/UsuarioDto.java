package com.cloud.senac.library.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsuarioDto {

    private Long id;

    private String nome;

    private LocalDate dtNascimento;

    private Integer cpf;

    private String senha;

    private String email;

    private boolean adm;

}
