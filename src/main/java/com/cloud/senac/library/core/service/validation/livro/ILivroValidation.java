package com.cloud.senac.library.core.service.validation.livro;

import java.util.List;

public interface ILivroValidation {

    void ifNotExistThrowException(List<Long> id);

}
