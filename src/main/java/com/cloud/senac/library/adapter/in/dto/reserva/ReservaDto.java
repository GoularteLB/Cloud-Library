package com.cloud.senac.library.adapter.in.dto.reserva;

import com.cloud.senac.library.adapter.in.dto.LivroDto;
import com.cloud.senac.library.adapter.in.dto.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservaDto(Long reservaId ,
                         LocalDate dataInicial,
                         LocalDate dataFinal,
                         LocalDate dataEntrega,
                         UsuarioDto usuario,
                         List<LivroDto> livrosReservados,
                         BigDecimal multaPorDia,
                         BigDecimal multaTotal) {
}
