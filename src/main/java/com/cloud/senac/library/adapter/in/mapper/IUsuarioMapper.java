package com.cloud.senac.library.adapter.in.mapper;

public interface IUsuarioMapper<D, E, R> extends IGenericMapper<D, E> {

    D convertRegisterToDto(R dto);

}
