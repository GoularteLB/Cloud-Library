package com.cloud.senac.library.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataEntrega;
    private BigDecimal multaPorDia;
    private Usuario usuario;
    private List<Livro> livroList;
}
