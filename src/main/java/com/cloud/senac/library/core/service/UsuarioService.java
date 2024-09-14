package com.cloud.senac.library.core.service;

import com.cloud.senac.library.adapter.in.dto.UsuarioDto;
import com.cloud.senac.library.adapter.out.entity.Usuario;
import com.cloud.senac.library.adapter.out.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto Cadastrar(UsuarioDto usuarioDto) {
        checkIfUsuarioDtoIsValid(usuarioDto);
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    private void checkIfUsuarioDtoIsValid(UsuarioDto usuarioDto) {
        if (usuarioDto == null || usuarioDto.getNome() == null || usuarioDto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do usuário precisa ser preenchido no cadastro");
        }
    }

    public UsuarioDto Editar(UsuarioDto usuarioDto) {
        checkIfUsuarioDtoIsValid(usuarioDto);
        if (usuarioDto.getId() == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do usuário para a edição");
        }

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDto.getId());
        if (optionalUsuario.isEmpty()) {
            throw new IllegalArgumentException("Usuário com o ID fornecido não encontrado");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario.setId(usuarioDto.getId());
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do usuário para a exclusão");
        }
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> Listar(UsuarioDto usuarioDto) {
        if (usuarioDto.getNome() != null && !usuarioDto.getNome().isBlank()) {
            return usuarioRepository.findUsuarioByName(usuarioDto.getNome()).stream()
                    .map(usuarioMapper::toDTO)
                    .collect(Collectors.toList());
        } else if (usuarioDto.getId() != null) {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDto.getId());
            return optionalUsuario.map(usuario -> List.of(usuarioMapper.toDTO(usuario))).orElseGet(List::of);
        }
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
