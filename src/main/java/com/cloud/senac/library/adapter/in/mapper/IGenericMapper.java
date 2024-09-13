package com.cloud.senac.library.adapter.in.mapper;

public interface IGenericMapper<D, E> {
    D toDTO(E entity);
    E toEntity(D dto);
}
