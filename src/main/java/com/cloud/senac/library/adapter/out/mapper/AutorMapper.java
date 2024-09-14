package com.cloud.senac.library.adapter.out.mapper;

import com.cloud.senac.library.adapter.out.entity.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Autor domainToEntity(com.cloud.senac.library.core.domain.Autor autor) {
        return modelMapper.map(autor, Autor.class);
    }

    public com.cloud.senac.library.core.domain.Autor EntityToDomain(Autor autor) {
        return modelMapper.map(autor, com.cloud.senac.library.core.domain.Autor.class);
    }

    public Optional<com.cloud.senac.library.core.domain.Autor> optionalEntityToOptionalDomain(Optional<Autor> optionalAutor) {
        return optionalAutor.map(this::EntityToDomain);
    }


}
