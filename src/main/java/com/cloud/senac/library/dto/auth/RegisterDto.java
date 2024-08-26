package com.cloud.senac.library.dto.auth;

import java.time.LocalDate;

public record RegisterDto(String nome,
                          String email,
                          String senha,
                          LocalDate dtNascimento,
                          Integer cpf) {
}
