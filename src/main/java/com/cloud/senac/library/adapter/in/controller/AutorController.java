package com.cloud.senac.library.adapter.in.controller;

import com.cloud.senac.library.adapter.in.dto.AutorDto;
import com.cloud.senac.library.adapter.in.mapper.IGenericMapper;
import com.cloud.senac.library.core.domain.Autor;
import com.cloud.senac.library.core.port.in.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/autor")
@RequiredArgsConstructor
@Tag(name = "Author Controller")
public class AutorController {

    private final IGenericService<Autor> autorService;
    private final IGenericMapper<AutorDto, Autor> autorMapper;

    @PostMapping
    @Operation(summary = "Save new Author by AuthorDTO")
    public AutorDto cadastrar(AutorDto autorDto) {
        return autorMapper.toDTO(
                autorService.Cadastrar(
                        autorMapper.toEntity(
                                autorDto
                        )
                )
        );
    }

    @PutMapping
    @Operation(summary = "Edit Author with autorDto")
    public AutorDto editar(AutorDto autorDto) {
        return autorMapper.toDTO(
                autorService.Editar(
                        autorMapper.toEntity(
                                autorDto
                        )
                )
        );
    }

    @DeleteMapping
    @Operation(summary = "Delete Author by Id")
    public void excluir(Long authorId) {
        autorService.Excluir(
                authorId
        );
    }

    @GetMapping
    public List<AutorDto> listar(AutorDto autorDto) {
        return autorService.Listar(
                autorMapper.toEntity(
                        autorDto
                )
        ).stream().map(autorMapper::toDTO).toList();
    }

}
