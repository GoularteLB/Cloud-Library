package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.service.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
@Tag(name = "Author Controller")
public class AutorController {

    private final IGenericService<AutorDto> autorService;

    @PostMapping
    @Operation(summary = "Save new Author by AuthorDTO")
    public AutorDto cadastrar(AutorDto autorDto) {
        return autorService.Cadastrar(autorDto);
    }

    @PutMapping
    @Operation(summary = "Edit Author with autorDto")
    public AutorDto editar(AutorDto autorDto) {
        return autorService.Editar(autorDto);
    }

    @DeleteMapping
    @Operation(summary = "Delete Author by Id")
    public void excluir(Long authorId) {
        autorService.Excluir(authorId);
    }
}
