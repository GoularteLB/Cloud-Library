package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.entity.Autor;
import com.cloud.senac.library.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorService implements IGenericService<AutorDto> {

    private final AutorRepository autorRepository;

    @Override
    public AutorDto Cadastrar(AutorDto autorDto) {
        checkIfAutorDtoIsValid(autorDto);
        autorRepository.save(new Autor(null, autorDto.nomeAutor(), null));
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
    public AutorDto Listar(AutorDto autorDto) {
        checkIfAutorDtoIsValid(autorDto);
        return null;
    }

    private void checkIfAutorDtoIsValid(final AutorDto autorDto) {
        if (autorDto == null || autorDto.nomeAutor() == null) {
            throw new IllegalArgumentException("Nome autor precisa ser preenchido no cadastro");
        }
    }

}
