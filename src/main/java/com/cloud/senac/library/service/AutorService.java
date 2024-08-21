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
        if (autorDto == null || autorDto.nomeAutor() == null) {
            throw new IllegalArgumentException("Nome autor precisa ser preenchido no cadastro");
        }
        autorRepository.save(new Autor(null, autorDto.nomeAutor(), null));
        return autorDto;
    }

    @Override
    public AutorDto Editar(AutorDto object) {
        return null;
    }

    @Override
    public void Excluir(AutorDto object) {

    }

    @Override
    public AutorDto Listar(AutorDto object) {
        return null;
    }

}
