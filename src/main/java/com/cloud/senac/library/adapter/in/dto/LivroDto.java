package com.cloud.senac.library.adapter.in.dto;



public record LivroDto(Long LivroId,String titulo, String sinopse, String categoria, Enum status, int estoque) {

}
