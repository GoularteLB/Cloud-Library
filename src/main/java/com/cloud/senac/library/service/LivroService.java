package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.LivroDto;
import org.springframework.stereotype.Service;

@Service
public class LivroService implements IGenericService<LivroDto> {

    @Override
    public LivroDto Cadastrar(LivroDto object) {
        if(object != null) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public LivroDto Editar(LivroDto object) {
        return null;
    }


    @Override
    public void Excluir(Long object) {
        return;
    }


    @Override
    public LivroDto Listar(LivroDto object) {
        return null;
    }
}
