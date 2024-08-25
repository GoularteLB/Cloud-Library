package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.UsuarioDto;
import com.cloud.senac.library.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UsuarioDto usuarioDto){
        return authService.login(usuarioDto);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioDto usuarioDto){
        return authService.register(usuarioDto);
    }

}
