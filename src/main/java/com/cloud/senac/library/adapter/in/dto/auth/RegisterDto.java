package com.cloud.senac.library.adapter.in.dto.auth;

import java.time.LocalDate;

public record RegisterDto(String nome,
                          String email,
                          String senha,
                          LocalDate dtNascimento,
                          Integer cpf) {
}
