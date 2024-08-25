package com.cloud.senac.library.mapper;

public interface IGenericMapper<D, E> {
    D toDTO(E entity);
    E toEntity(D dto);
}
