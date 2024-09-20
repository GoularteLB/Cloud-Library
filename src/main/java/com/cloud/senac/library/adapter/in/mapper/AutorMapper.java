package com.cloud.senac.library.adapter.in.mapper;

import com.cloud.senac.library.adapter.in.dto.AutorDto;
import com.cloud.senac.library.core.domain.Autor;
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
