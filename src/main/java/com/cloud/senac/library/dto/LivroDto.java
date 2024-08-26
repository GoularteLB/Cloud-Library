package com.cloud.senac.library.dto;



public record LivroDto(Long LivroId,String titulo, String sinopse, String categoria, Enum status, int estoque) {

}
