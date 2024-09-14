package com.cloud.senac.library.core.service.reserva;

import com.cloud.senac.library.adapter.in.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.adapter.in.dto.reserva.ReservaDto;
import com.cloud.senac.library.adapter.out.entity.Reserva;
import com.cloud.senac.library.adapter.out.repository.ReservaRepository;
import com.cloud.senac.library.core.service.validation.UsuarioValidationService;
import com.cloud.senac.library.core.service.validation.livro.ILivroValidation;

import java.time.LocalDate;
import java.util.List;

public class ReservaService {

    private ReservaRepository reservaRepository;
    private UsuarioValidationService usuarioValidationService;
    private ILivroValidation livroValidationService;

    public ReservaService(ReservaRepository reservaRepository, UsuarioValidationService usuarioValidationService, ILivroValidation livroValidationService) {
        this.reservaRepository = reservaRepository;
        this.usuarioValidationService = usuarioValidationService;
        this.livroValidationService = livroValidationService;
    }

    public ReservaDto reservar(CadastroReservaDto dto) {
        usuarioValidationService.ifNotExistThrowException(dto.usuarioId());
        livroValidationService.ifNotExistThrowException(dto.listaDeLivros());
        Reserva reserva = reservaMapper.convertDtoCadastroToEntity(dto);
        return reservaMapper.toDTO(reservaRepository.save(reserva));
    }

    public ReservaDto consultarReserva(Long reservaId) {
        return reservaMapper.toDTO(
                reservaRepository.findById(reservaId).orElseThrow(() -> new RuntimeException("Reserva não encontrado"))
        );
    }

    public List<ReservaDto> listarReservas() {
        return reservaRepository.findAll().stream().map(reservaMapper::toDTO).toList();
    }

    public List<ReservaDto> listarReservasByUsuarioId(Long usuarioId) {
        usuarioValidationService.ifNotExistThrowException(usuarioId);
        return reservaRepository.findReservaByUsuarioId(usuarioId)
                .stream()
                .map(reservaMapper::toDTO)
                .toList();
    }

    public String quitarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new RuntimeException("Reserva não encontrado"));
        reserva.setDataEntrega(LocalDate.now());
        reservaRepository.save(reserva);
        return String.format("Reserva %s quitada com sucesso!", reservaId);
    }
}
