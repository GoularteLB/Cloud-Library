package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.entity.Autor;
import com.cloud.senac.library.mapper.IGenericMapper;
import com.cloud.senac.library.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService implements IGenericService<AutorDto> {

    private final AutorRepository autorRepository;
    private final IGenericMapper<AutorDto, Autor> autorMapper;

    @Override
    public AutorDto Cadastrar(AutorDto autorDto) {
        checkIfAutorDtoIsValid(autorDto);
        autorRepository.save(autorMapper.toEntity(autorDto));
        return autorDto;
    }

    @Override
    public AutorDto Editar(AutorDto autorDto) {
        checkIfAutorDtoIsValid(autorDto);
        if (autorDto.autorId() == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do autor para a exclusão");
        }
        autorRepository.updateAuthorName(autorDto.autorId(), autorDto.nomeAutor());
        return autorDto;
    }

    @Override
    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do autor para a exclusão");
        }
        autorRepository.deleteById(id);
    }

    @Override
    public List<AutorDto> Listar(AutorDto autorDto) {
        if (autorDto.nomeAutor() != null && !autorDto.nomeAutor().isBlank()) {
            return autorRepository.listAuthorByName(autorDto.nomeAutor()).stream().map(autorMapper::toDTO).toList();
        } else if (autorDto.autorId() != null) {
            return autorRepository.findById(autorDto.autorId()).stream().map(autorMapper::toDTO).toList();
        }
        return autorRepository.findAll().stream().map(autorMapper::toDTO).toList();
    }

    private void checkIfAutorDtoIsValid(final AutorDto autorDto) {
        if (autorDto == null || autorDto.nomeAutor() == null) {
            throw new IllegalArgumentException("Nome autor precisa ser preenchido no cadastro");
        }
    }

}
