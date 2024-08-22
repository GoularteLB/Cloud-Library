package com.cloud.senac.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AutorDto(Long autorId, String nomeAutor) { }
