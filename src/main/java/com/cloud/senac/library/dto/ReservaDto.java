package com.cloud.senac.library.dto;

import java.time.LocalDate;

public record ReservaDto (LocalDate dataInicial, LocalDate dataFinal, LocalDate dataEntrega, Double multa) {

}
