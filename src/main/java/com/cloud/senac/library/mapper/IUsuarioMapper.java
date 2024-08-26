package com.cloud.senac.library.mapper;

public interface IUsuarioMapper<D, E, R> extends IGenericMapper<D, E> {

    D convertRegisterToDto(R dto);

}
