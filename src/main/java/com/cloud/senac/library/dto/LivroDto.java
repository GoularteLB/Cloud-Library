package com.cloud.senac.library.dto;



public record LivroDto(String titulo, String sinopse, String categoria, Enum status, int estoque) {

}
