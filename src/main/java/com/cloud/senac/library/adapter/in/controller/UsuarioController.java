package com.cloud.senac.library.adapter.in.controller;

import com.cloud.senac.library.adapter.in.dto.UsuarioDto;
import com.cloud.senac.library.core.port.in.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/usuario")
@RequiredArgsConstructor
@Tag(name = "User Controller")
public class UsuarioController {

    private final IGenericService<UsuarioDto> usuarioService;

    @PostMapping
    @Operation(summary = "Save new Author by UserDTO")
    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
       return usuarioService.Cadastrar(usuarioDto);
    }

    @PutMapping
    @Operation(summary = "Edit User with usuarioDto")
    public UsuarioDto editar(UsuarioDto usuarioDto) {
        return usuarioService.Editar(usuarioDto);
    }

    @DeleteMapping
    @Operation(summary = "Delete User by Id")
    public void excluir(Long usuarioId) {
        usuarioService.Excluir(usuarioId);
    }

    @GetMapping
    public void listar(UsuarioDto usuarioDto) {
        usuarioService.Listar(usuarioDto);
    }

}
