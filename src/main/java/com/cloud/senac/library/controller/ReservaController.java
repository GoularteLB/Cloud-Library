package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.reserva.CadastroReservaDto;
import com.cloud.senac.library.dto.reserva.ReservaDto;
import com.cloud.senac.library.entity.Reserva;
import com.cloud.senac.library.service.reserva.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reserva")
public class ReservaController {

    private final IReservaService<ReservaDto, CadastroReservaDto> reservaService;

    @PostMapping("/reservar")
    public ReservaDto reservar(CadastroReservaDto dto) {
       return reservaService.reservar(dto);
    }

    @GetMapping("/{reservaId}")
    public ReservaDto consultarReserva(@PathVariable("reservaId") Long reservaId) {
        return reservaService.consultarReserva(reservaId);
    }

    @GetMapping
    public List<ReservaDto> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/user/{usuarioId}")
    public List<ReservaDto> listarReservasByUsuarioId(@PathVariable("usuarioId") Long usuarioId) {
        return reservaService.listarReservasByUsuarioId(usuarioId);
    }

    @PutMapping("/{reservaId}")
    public String quitarReserva(Long reservaId) {
        return reservaService.quitarReserva(reservaId);
    }

}
