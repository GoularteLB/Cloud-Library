package com.cloud.senac.library.adapter.out.repository;

import com.cloud.senac.library.adapter.out.mapper.AutorMapper;
import com.cloud.senac.library.core.domain.Autor;
import com.cloud.senac.library.core.port.out.AutorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AutorRepositoryAdapter implements AutorRepositoryPort {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    @Override
    public Autor save(Autor autor) {
        return autorMapper.EntityToDomain(
                autorRepository.save(
                        autorMapper.domainToEntity(autor)
                )
        );
    }

    @Override
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public List<Autor> findAll() {
        return autorRepository
                .findAll()
                .stream()
                .map(
                        autorMapper::EntityToDomain
                ).toList();
    }

    @Override
    public void updateAuthorName(Long id, String authorName) {
        autorRepository.updateAuthorName(id, authorName);
    }

    @Override
    public List<Autor> listAuthorByName(String autorName) {
        return autorRepository.listAuthorByName(autorName).stream().map(autorMapper::EntityToDomain).toList();
    }

    @Override
    public Optional<Autor> findById(Long autorId) {
        return autorMapper.optionalEntityToOptionalDomain(autorRepository.findById(autorId));
    }
}
