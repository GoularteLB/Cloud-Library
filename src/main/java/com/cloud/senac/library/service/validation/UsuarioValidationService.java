package com.cloud.senac.library.service.validation;

import com.cloud.senac.library.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioValidationService implements IGenericValidation {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void ifNotExistThrowException(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario não existe");
        }
    }

}
