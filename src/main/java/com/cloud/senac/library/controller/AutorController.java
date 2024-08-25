package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.service.IGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    private final IGenericService<AutorDto> autorService;

    @PostMapping
    public AutorDto cadastrar(AutorDto autorDto) {
        return autorService.Cadastrar(autorDto);
    }

    @PutMapping
    public AutorDto editar(AutorDto autorDto) {
        return autorService.Editar(autorDto);
    }

    @DeleteMapping
    public void excluir(Long authorId) {
        autorService.Excluir(authorId);
    }

    @GetMapping
    public void listar(AutorDto autorDto) {
        autorService.Listar(autorDto);
    }

}
