package com.cloud.senac.library.core.service.validation.livro;

import com.cloud.senac.library.adapter.out.entity.Livro;
import com.cloud.senac.library.adapter.out.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroValidationService implements ILivroValidation {

    private final LivroRepository livroRepository;

    @Override
    public void ifNotExistThrowException(List<Long> ids) {
        List<Livro> livroList = livroRepository.findAllById(ids);
        if (!new HashSet<>(livroList).containsAll(ids)) {
            throw  new RuntimeException("Livro não existente");
        }
    }

}
