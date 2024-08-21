package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.service.IGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    private final IGenericService<AutorDto> autorService;

    @PostMapping
    public AutorDto cadastrar(AutorDto autorDto) {
        return autorService.Cadastrar(autorDto);
    }
}
