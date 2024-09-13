package com.cloud.senac.library.adapter.in.mapper;

import com.cloud.senac.library.adapter.in.dto.UsuarioDto;
import com.cloud.senac.library.adapter.in.dto.auth.RegisterDto;
import com.cloud.senac.library.adapter.out.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements IUsuarioMapper<UsuarioDto, Usuario, RegisterDto> {

    @Override
    public UsuarioDto toDTO(Usuario entity) {
        if (entity == null) {
            return null;
        }
        return new UsuarioDto(
                entity.getId(),
                entity.getNome(),
                entity.getDtNascimento(),
                entity.getCpf(),
                entity.getSenha(),
                entity.getEmail(),
                entity.isAdm()
        );
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        return new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getDtNascimento(),
                dto.getCpf(),
                dto.getSenha(),
                dto.getEmail(),
                dto.isAdm()
        );
    }

    @Override
    public UsuarioDto convertRegisterToDto(RegisterDto dto) {
        if (dto == null) {
            return null;
        }
        return new UsuarioDto(null, dto.nome(), dto.dtNascimento(), dto.cpf(), dto.senha(), dto.email(), false);
    }
}
