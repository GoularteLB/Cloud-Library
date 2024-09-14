package com.cloud.senac.library.core.service.auth;

import com.cloud.senac.library.infra.security.JwtTokenService;
import com.cloud.senac.library.adapter.in.dto.UsuarioDto;
import com.cloud.senac.library.adapter.in.dto.auth.LoginDto;
import com.cloud.senac.library.adapter.in.dto.auth.RegisterDto;
import com.cloud.senac.library.adapter.out.entity.Usuario;
import com.cloud.senac.library.adapter.out.repository.UsuarioRepository;
import com.cloud.senac.library.core.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService tokenService;

    public AuthService(UsuarioRepository usuarioRepository, UsuarioService usuarioService, PasswordEncoder passwordEncoder, JwtTokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public ResponseEntity register(RegisterDto registerDto){
        Optional<Usuario> user = this.usuarioRepository.findByEmail(registerDto.email());
        if(user.isEmpty()) {
            UsuarioDto usuarioDto = usuarioMapper.convertRegisterToDto(registerDto);
            usuarioDto.setSenha(passwordEncoder.encode(registerDto.senha()));
            return ResponseEntity.ok(usuarioService.Cadastrar(usuarioDto));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity registerAdm(RegisterDto registerDto) {
        Optional<Usuario> user = this.usuarioRepository.findByEmail(registerDto.email());
        if(user.isEmpty()) {
            UsuarioDto usuarioDto = usuarioMapper.convertRegisterToDto(registerDto);
            usuarioDto.setSenha(passwordEncoder.encode(registerDto.senha()));
            usuarioDto.setAdm(true);
            return ResponseEntity.ok(usuarioService.Cadastrar(usuarioDto));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity login(LoginDto loginDto){
        Usuario usuario = this.usuarioRepository.findByEmail(loginDto.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(loginDto.password(), usuario.getSenha())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

}
