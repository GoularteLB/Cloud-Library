package com.cloud.senac.library.mapper;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.entity.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper implements IGenericMapper<AutorDto, Autor>{

    @Override
    public AutorDto toDTO(Autor entity) {
        return new AutorDto(entity.getId(), entity.getNomeAutor());
    }

    @Override
    public Autor toEntity(AutorDto dto) {
        return new Autor(dto.autorId(), dto.nomeAutor(), null);
    }

}
