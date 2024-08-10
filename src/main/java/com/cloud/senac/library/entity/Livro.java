package com.cloud.senac.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sinopse;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private Enum status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

}
