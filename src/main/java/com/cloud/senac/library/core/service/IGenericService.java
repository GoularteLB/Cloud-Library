package com.cloud.senac.library.core.service;


import java.util.List;

public interface IGenericService<T> {

    T Cadastrar(T object);
    T Editar(T object);
    void Excluir(Long id);
    List<T> Listar(T object);

}
