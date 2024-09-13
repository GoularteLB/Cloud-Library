package com.cloud.senac.library.adapter.in.mapper;

import com.cloud.senac.library.adapter.in.dto.LivroDto;
import com.cloud.senac.library.adapter.out.entity.Livro;
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
