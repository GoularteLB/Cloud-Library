package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.entity.Livro;
import com.cloud.senac.library.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService implements IGenericService<LivroDto> {

    private final LivroRepository livroRepository;

    @Override
    public LivroDto Cadastrar(LivroDto livroDto) {
        if(livroDto == null || livroDto.titulo() == null){
            throw new IllegalArgumentException("Titulo do livro necessita ser preenchido");
        }
        livroRepository.save(new Livro( livroDto.id() ,null,livroDto.titulo(), livroDto.categoria(), livroDto.status(), livroDto.estoque(), null));
        return livroDto;
    }

    public LivroDto Editar(LivroDto object) {
        return null;
    }


    public void Excluir(LivroDto object) {
        return;
    }


    public LivroDto Listar(LivroDto object) {
        return null;
    }
}
