package com.cloud.senac.library.infra.bean;

import com.cloud.senac.library.adapter.out.mapper.AutorMapper;
import com.cloud.senac.library.adapter.out.repository.AutorRepository;
import com.cloud.senac.library.adapter.out.repository.AutorRepositoryAdapter;
import com.cloud.senac.library.core.service.AutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceConfig {

    @Bean
    public AutorService autorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        return new AutorService(
                new AutorRepositoryAdapter(
                        autorRepository,
                        autorMapper
                )
        );
    }

}
