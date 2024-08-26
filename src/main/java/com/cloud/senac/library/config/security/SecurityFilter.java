package com.cloud.senac.library.config.security;

import com.cloud.senac.library.entity.Usuario;
import com.cloud.senac.library.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class bSecurityFilter extends OncePerRequestFilter {

    private final UsuarioRepository usuarioRepository;
    private final JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/swagger-ui/") || request.getRequestURI().contains("/v3/api-docs") || request.getRequestURI().contains("auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = recoverToken(request);
        String login = jwtTokenService.validateToken(token);

        if (login != null) {
            Usuario usuario = usuarioRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("Não autorizado"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority(usuario.isAdm() ? "admin" : "user"));
            Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        return authHeader != null ? authHeader.replace("Bearer ", "") : null;
    }
}
