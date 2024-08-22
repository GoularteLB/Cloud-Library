package com.cloud.senac.library.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivroDto {

    private String sinopse;

    private String titulo;

    private String categoria;

    private Enum status;

    private int estoque;
}
