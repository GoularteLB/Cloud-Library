package com.cloud.senac.library.service.reserva;

import java.util.List;

public interface IReservaService<D, E> {

    D reservar(E dto);
    D consultarReserva(Long reservaId);
    List<D> listarReservas();
    List<D> listarReservasByUsuarioId(Long usuarioId);
    String quitarReserva(Long reservaId);

}
