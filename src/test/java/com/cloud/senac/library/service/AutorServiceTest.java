package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.AutorDto;
import com.cloud.senac.library.repository.AutorRepository;
import jakarta.persistence.NonUniqueResultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {

    @InjectMocks
    private AutorService autorService;
    @Mock
    private AutorRepository autorRepository;


    @Nested
    class cadastroTests{

        @Test
        void shouldReturnIllegalArgumentException_whenAutorDtoIsNull() {
            assertThatCode(() -> autorService.Cadastrar(null)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void shouldReturnIllegalArgumentException_whenAutorNameInAutoDtoIsNull() {
            assertThatCode(() -> autorService.Cadastrar(new AutorDto(null))).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void shouldReturnAutorDto_whenAutorDtoHasValidName() {
            String autorName = "Arthur Connon Doyle";
            assertThatCode(() -> {
                        AutorDto autorDto = autorService.Cadastrar(new AutorDto(autorName));
                        Assertions.assertNotNull(autorDto);
                        Assertions.assertEquals(autorName, autorDto.nomeAutor());
                    }
            ).doesNotThrowAnyException();
            verify(autorRepository, times(1)).save(any());
        }

        @Test
        void shouldReturnNonUniqueResultException_whenHasTheAutorNameInDatabase() {
            String autorName = "Arthur Connon Doyle";
            when(autorRepository.save(any())).thenThrow(NonUniqueResultException.class);
            assertThatCode(() -> autorService.Cadastrar(new AutorDto(autorName))).isInstanceOf(NonUniqueResultException.class);
        }

    }


    @Nested
    class excluirTests {

        @Test
        void shouldBeCalledDeleteById_whenExcluirMethodHasBeenCalled() {
            Long autorId = 1L;
            autorService.Excluir(autorId);
            verify(autorRepository, times(1)).deleteById(autorId);
        }

        @Test
        void shouldReturnIllegalArgumentException_whenAutorIdIsNull() {
            assertThatCode(() -> autorService.Excluir(null)).isInstanceOf(IllegalArgumentException.class);
            verify(autorRepository, never()).deleteById(any());
        }

    }



}
