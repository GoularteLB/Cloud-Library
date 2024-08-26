package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.LivroDto;
import com.cloud.senac.library.entity.Livro;
import com.cloud.senac.library.mapper.IGenericMapper;
import com.cloud.senac.library.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService implements IGenericService<LivroDto> {

    private final LivroRepository livroRepository;
    private final IGenericMapper<LivroDto, Livro> livroMapper;

    @Override
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

    @Override
    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("precisa ser fornecido um id de livro valido");
        }
        livroRepository.deleteById(id);
    }

    @Override
    public List<LivroDto> Listar(final LivroDto livroDto) {
        if (livroDto.titulo() != null && !livroDto.titulo().isBlank()) {
            return livroRepository.findLivroByName(livroDto.titulo()).stream().map(livroMapper::toDTO).toList();
        } else if(livroDto.LivroId() != null) {
            return livroRepository.findById(livroDto.LivroId()).stream().map(livroMapper::toDTO).toList();
        }
        return livroRepository.findAll().stream().map(livroMapper::toDTO).toList();
    }
}
