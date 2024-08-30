package com.cloud.senac.library.mapper;

public interface IReservaMapper<D,C,E> extends IGenericMapper<D,E>{

    public E convertDtoCadastroToEntity(C dto);

}
