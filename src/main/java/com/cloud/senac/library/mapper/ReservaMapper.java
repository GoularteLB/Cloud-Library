package com.cloud.senac.library.mapper;

import com.cloud.senac.library.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.dto.reserva.ReservaDto;
import com.cloud.senac.library.entity.Reserva;

public class ReservaMapper implements IReservaMapper<ReservaDto, CadastroReservaDto, Reserva>{


    @Override
    public Reserva convertDtoCadastroToEntity(CadastroReservaDto dto) {
        return null;
    }

    @Override
    public ReservaDto toDTO(Reserva entity) {
        return null;
    }

    @Override
    public Reserva toEntity(ReservaDto dto) {
        return null;
    }
}
