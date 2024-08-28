package com.cloud.senac.library.service;

import com.cloud.senac.library.dto.ReservaDto;
import com.cloud.senac.library.repository.AutorRepository;
import com.cloud.senac.library.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService implements IGenericService<ReservaDto> {

    private final ReservaRepository reservaRepository;

}
