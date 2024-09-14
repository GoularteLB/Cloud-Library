package com.cloud.senac.library.core.service;

import com.cloud.senac.library.adapter.in.dto.LivroDto;
import com.cloud.senac.library.adapter.out.entity.Livro;
import com.cloud.senac.library.adapter.out.repository.LivroRepository;

import java.util.List;

public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroDto Cadastrar(LivroDto livroDto) {
        if (livroDto == null || livroDto.titulo() == null) {
            throw new IllegalArgumentException("Titulo do livro necessita ser preenchido");
        }
        livroRepository.save(new Livro(null, null, livroDto.titulo(), livroDto.categoria(), livroDto.status(), livroDto.estoque(), null));
        return livroDto;
    }

    public LivroDto Editar(LivroDto livroDto) {
        if (livroDto.LivroId() == null) {
            throw new IllegalArgumentException("Forneça um id valido para o livro");
        }
        livroRepository.updateLivroName(livroDto.LivroId(), livroDto.titulo());
        return livroDto;
    }

    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("precisa ser fornecido um id de livro valido");
        }
        livroRepository.deleteById(id);
    }

    public List<LivroDto> Listar(final LivroDto livroDto) {
        if (livroDto.titulo() != null && !livroDto.titulo().isBlank()) {
            return livroRepository.findLivroByName(livroDto.titulo()).stream().map(livroMapper::toDTO).toList();
        } else if(livroDto.LivroId() != null) {
            return livroRepository.findById(livroDto.LivroId()).stream().map(livroMapper::toDTO).toList();
        }
        return livroRepository.findAll().stream().map(livroMapper::toDTO).toList();
    }
}
