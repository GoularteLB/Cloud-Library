package com.cloud.senac.library.controller;

import com.cloud.senac.library.dto.auth.LoginDto;
import com.cloud.senac.library.dto.auth.RegisterDto;
import com.cloud.senac.library.service.auth.IAuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller")
public class AuthController {

    private final IAuthService<LoginDto, RegisterDto> authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        return authService.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }

    @PostMapping("/register/adm")
    public ResponseEntity registerAdm(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }

}
