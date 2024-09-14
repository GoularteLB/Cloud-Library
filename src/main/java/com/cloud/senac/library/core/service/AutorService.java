package com.cloud.senac.library.core.service;

import com.cloud.senac.library.core.domain.Autor;
import com.cloud.senac.library.core.port.out.AutorRepositoryPort;

import java.util.List;

public class AutorService {

    private AutorRepositoryPort autorRepositoryPort;

    public AutorService(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    public Autor Cadastrar(Autor autor) {
//        checkIfAutorDtoIsValid(autorDto);
        autorRepositoryPort.save(autor);
        return autor;
    }

    public Autor Editar(Autor autor) {
//        checkIfAutorDtoIsValid(autorDto);
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do autor para a exclusão");
        }
        autorRepositoryPort.updateAuthorName(autor.getId(), autor.getNomeAutor());
        return autor;
    }

    public void Excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Precisa ser fornecido o id do autor para a exclusão");
        }
        autorRepositoryPort.deleteById(id);
    }

    public List<Autor> Listar(Autor autor) {
        if (autor.getNomeAutor() != null && !autor.getNomeAutor().isBlank()) {
            return autorRepositoryPort.listAuthorByName(autor.getNomeAutor());
        } else if (autor.getId() != null) {
            return List.of(autorRepositoryPort.findById(autor.getId()).orElseThrow(RuntimeException::new));
        }
        return autorRepositoryPort.findAll();
    }

    private void checkIfAutorDtoIsValid(final Autor autor) {
        if (autor == null || autor.getNomeAutor() == null) {
            throw new IllegalArgumentException("Nome autor precisa ser preenchido no cadastro");
        }
    }

}
