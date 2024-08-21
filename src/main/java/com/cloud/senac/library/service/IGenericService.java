package com.cloud.senac.library.service;


public interface IGenericService<T> {
    T Cadastrar(T object);
    T Editar(T object);
    void Excluir(Long object);
    T Listar(T object);
}
