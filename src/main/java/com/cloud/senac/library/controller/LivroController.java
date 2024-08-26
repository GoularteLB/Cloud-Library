package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.service.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livrp")
@RequiredArgsConstructor
@Tag(name = "Livro Controller")
public class LivroController {

    private final IGenericService<LivroDto> livroService;

    @PostMapping
    @Operation(summary = "Save a new book by BookDto")
    public LivroDto cadastrar(LivroDto livroDto ){return livroService.Cadastrar(livroDto);}



}
