package com.cloud.senac.library.service;


import com.cloud.senac.library.adapter.out.repository.LivroRepository;
import com.cloud.senac.library.core.service.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {

    @InjectMocks
    private LivroService livroService;
    @Mock
    private LivroRepository livroRepository;

    @Test
    void shouldReturnIllegalArgumentException_whenLivroDtoIsNull(){

    }
}
