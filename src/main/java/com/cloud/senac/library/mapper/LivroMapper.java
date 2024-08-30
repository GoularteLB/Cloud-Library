package com.cloud.senac.library.mapper;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.entity.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper implements IGenericMapper<LivroDto, Livro>{
    @Override
    public LivroDto toDTO(Livro entity) {
        return null;
    }

    @Override
    public Livro toEntity(LivroDto dto) {
        return null;
    }
}
