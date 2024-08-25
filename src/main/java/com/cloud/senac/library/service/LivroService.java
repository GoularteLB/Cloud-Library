package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.entity.Livro;
import com.cloud.senac.library.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService implements IGenericService<LivroDto> {

    private final LivroRepository livroRepository;

    @Override
    public LivroDto Cadastrar(LivroDto livroDto) {
        if(livroDto == null || livroDto.titulo() == null){
            throw new IllegalArgumentException("Titulo do livro necessita ser preenchido");
        }
        livroRepository.save(new Livro( null ,null,livroDto.titulo(), livroDto.categoria(), livroDto.status(), livroDto.estoque(), null));
        return livroDto;
    }

    public LivroDto Editar(LivroDto object) {
        return null;
    }


    public void Excluir(Long object) {
        return;
    }


    public List<LivroDto> Listar(LivroDto object) {
        return null;
    }
}
