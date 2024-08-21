package com.cloud.senac.library.service;


import com.cloud.senac.library.dto.AutorDto;

public interface IGenericService<T> {

    T Cadastrar(T object);
    T Editar(T object);
    void Excluir(Long id);
    T Listar(T object);
}
