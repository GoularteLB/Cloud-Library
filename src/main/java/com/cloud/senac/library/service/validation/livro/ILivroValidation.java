package com.cloud.senac.library.service.validation.livro;

import java.util.List;

public interface ILivroValidation {

    void ifNotExistThrowException(List<Long> id);

}
