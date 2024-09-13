package com.cloud.senac.library.core.service.reserva;

import com.cloud.senac.library.adapter.in.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.adapter.in.dto.reserva.ReservaDto;
import com.cloud.senac.library.adapter.out.entity.Reserva;
import com.cloud.senac.library.adapter.in.mapper.IReservaMapper;
import com.cloud.senac.library.adapter.out.repository.ReservaRepository;
import com.cloud.senac.library.core.service.validation.IGenericValidation;
import com.cloud.senac.library.core.service.validation.livro.ILivroValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService<ReservaDto, CadastroReservaDto> {

    private final IReservaMapper<ReservaDto, CadastroReservaDto, Reserva> reservaMapper;
    private final ReservaRepository reservaRepository;
    private final IGenericValidation usuarioValidationService;
    private final ILivroValidation livroValidationService;

    @Override
    public ReservaDto reservar(CadastroReservaDto dto) {
        usuarioValidationService.ifNotExistThrowException(dto.usuarioId());
        livroValidationService.ifNotExistThrowException(dto.listaDeLivros());
        Reserva reserva = reservaMapper.convertDtoCadastroToEntity(dto);
        return reservaMapper.toDTO(reservaRepository.save(reserva));
    }

    @Override
    public ReservaDto consultarReserva(Long reservaId) {
        return reservaMapper.toDTO(
                reservaRepository.findById(reservaId).orElseThrow(() -> new RuntimeException("Reserva não encontrado"))
        );
    }

    @Override
    public List<ReservaDto> listarReservas() {
        return reservaRepository.findAll().stream().map(reservaMapper::toDTO).toList();
    }

    @Override
    public List<ReservaDto> listarReservasByUsuarioId(Long usuarioId) {
        usuarioValidationService.ifNotExistThrowException(usuarioId);
        return reservaRepository.findReservaByUsuarioId(usuarioId)
                .stream()
                .map(reservaMapper::toDTO)
                .toList();
    }

    @Override
    public String quitarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new RuntimeException("Reserva não encontrado"));
        reserva.setDataEntrega(LocalDate.now());
        reservaRepository.save(reserva);
        return String.format("Reserva %s quitada com sucesso!", reservaId);
    }
}
