package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.UsuarioDto;
import com.cloud.senac.library.entity.Usuario;
import com.cloud.senac.library.mapper.IGenericMapper;
import com.cloud.senac.library.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IGenericService<UsuarioDto> {

    private final UsuarioRepository usuarioRepository;
    private final IGenericMapper<UsuarioDto, Usuario> usuarioMapper;

    @Override
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

    @Override
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

    @Override
    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do usuário para a exclusão");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
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
