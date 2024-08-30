package com.cloud.senac.library.service.reserva;

import com.cloud.senac.library.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.dto.reserva.ReservaDto;
import com.cloud.senac.library.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService<ReservaDto, CadastroReservaDto> {

    private final ReservaRepository reservaRepository;

    @Override
    public ReservaDto reservar(CadastroReservaDto dto) {
        return null;
    }

    @Override
    public ReservaDto consultarReserva(Long reservaId) {
        return null;
    }

    @Override
    public List<ReservaDto> listarReservas() {
        return List.of();
    }

    @Override
    public List<ReservaDto> listarReservasByUsuarioId(Long usuarioId) {
        return List.of();
    }

    @Override
    public String quitarReserva(Long reservaId) {
        return "";
    }
}
