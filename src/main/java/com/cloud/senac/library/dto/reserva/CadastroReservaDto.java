package com.cloud.senac.library.dto.reserva;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CadastroReservaDto(LocalDate dataFinal, Long usuarioId, BigDecimal multaPorDia, List<Long> listaDeLivros) {
}
