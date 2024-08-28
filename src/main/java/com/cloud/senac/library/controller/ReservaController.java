package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.dto.ReservaDto;
import com.cloud.senac.library.service.IGenericService;
import com.cloud.senac.library.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final IGenericService<ReservaDto> reservaService;

    @PostMapping
    public ReservaDto cadastrar(ReservaDto reservaDto) {return reservaDto}

    @PutMapping
    public ReservaDto editar(ReservaDto reservaDto} {return ReservaService}

@DeleteMapping
public void excluir(Long authorId) {return ReservaService}

}
