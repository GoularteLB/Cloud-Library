package com.cloud.senac.library.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Livro {
    private Long id;
    private String sinopse;
    private String titulo;
    private String categoria;
    private Enum status;
    private int estoque;
    private Autor autor;
}
