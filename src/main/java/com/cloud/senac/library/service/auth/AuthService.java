package com.cloud.senac.library.service;

import com.cloud.senac.library.config.security.JwtTokenService;
import com.cloud.senac.library.dto.UsuarioDto;
import com.cloud.senac.library.entity.Usuario;
import com.cloud.senac.library.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService<LoginDto, RegisterDto> {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService tokenService;
    private final IUsuarioMapper<UsuarioDto, Usuario, RegisterDto> usuarioMapper;

    public ResponseEntity register(@RequestBody UsuarioDto usuarioDto){
        Optional<Usuario> user = this.usuarioRepository.findByEmail(usuarioDto.getEmail());
        if(user.isEmpty()) {
            usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
            return ResponseEntity.ok(usuarioService.Cadastrar(usuarioDto));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity login(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = this.usuarioRepository.findByEmail(usuarioDto.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(usuarioDto.getSenha(), usuario.getSenha())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }
}
