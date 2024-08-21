package com.cloud.senac.library.dto;
import lombok.AllArgsConstructor;
import lombok.Data;


public record LivroDto(String sinopse, String titulo, String categoria, Enum status, int estoque) {

}
