package com.cloud.senac.library.service;

import com.cloud.senac.library.entity.Usuario;
import com.cloud.senac.library.service.IGenericService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IGenericService <Usuario>{

    @Override
    public Usuario Cadastrar(Usuario usuario) {
        return null;
    }

    public Usuario Editar(Usuario usuario) {
        return null;
    }


    public void Excluir(Usuario usuario) {
        return;
    }


    public Usuario Listar(Usuario usuario) {
        return null;
    }
}
