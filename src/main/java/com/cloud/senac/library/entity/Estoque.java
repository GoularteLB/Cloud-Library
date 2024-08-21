package com.cloud.senac.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int qtdEstoque;
}
