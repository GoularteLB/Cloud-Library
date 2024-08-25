package com.cloud.senac.library.service;


import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.dto.UsuarioDto;

import java.util.List;

public interface IGenericService<T> {

    T Cadastrar(T object);
    T Editar(T object);
    void Excluir(Long id);
    List<T> Listar(T object);

}
