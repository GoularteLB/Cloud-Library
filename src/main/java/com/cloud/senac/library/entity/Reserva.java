package com.cloud.senac.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataEntrega;
    private Double multaPorDia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Livro> livroList;

    @PrePersist
    void prePersist() {
        if (dataInicial == null) {
            dataInicial = LocalDate.now();
        }
    }
}
