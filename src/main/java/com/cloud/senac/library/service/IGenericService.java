package com.cloud.senac.library.service;


public interface IGenericService<T> {
    T Cadastrar(Object object);
    T Editar(Object object);
    void Excluir(Object object);
    T Listar(Object object);
}
