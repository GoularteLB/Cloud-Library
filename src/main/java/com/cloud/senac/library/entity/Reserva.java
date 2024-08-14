package com.cloud.senac.library.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataEntrega;
    private Double multa;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Livro livro;
}
