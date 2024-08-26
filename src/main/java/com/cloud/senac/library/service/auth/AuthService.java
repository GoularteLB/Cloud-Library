package com.cloud.senac.library.service.auth;

import com.cloud.senac.library.config.security.JwtTokenService;
import com.cloud.senac.library.dto.UsuarioDto;
import com.cloud.senac.library.dto.auth.LoginDto;
import com.cloud.senac.library.dto.auth.RegisterDto;
import com.cloud.senac.library.entity.Usuario;
import com.cloud.senac.library.mapper.IUsuarioMapper;
import com.cloud.senac.library.repository.UsuarioRepository;
import com.cloud.senac.library.service.UsuarioService;
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

    @Override
    public ResponseEntity register(RegisterDto registerDto){
        Optional<Usuario> user = this.usuarioRepository.findByEmail(registerDto.email());
        if(user.isEmpty()) {
            UsuarioDto usuarioDto = usuarioMapper.convertRegisterToDto(registerDto);
            usuarioDto.setSenha(passwordEncoder.encode(registerDto.senha()));
            return ResponseEntity.ok(usuarioService.Cadastrar(usuarioDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
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

    @Override
    public ResponseEntity login(LoginDto loginDto){
        Usuario usuario = this.usuarioRepository.findByEmail(loginDto.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(loginDto.password(), usuario.getSenha())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

}
