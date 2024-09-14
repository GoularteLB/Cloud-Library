package com.cloud.senac.library.core.port.out;

import com.cloud.senac.library.core.domain.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorRepositoryPort {
    Autor save(Autor autor);
    void deleteById(Long id);
    List<Autor> findAll();
    void updateAuthorName(Long id, String authorName);
    List<Autor> listAuthorByName(String autorName);
    Optional<Autor> findById(Long autorId);
}
