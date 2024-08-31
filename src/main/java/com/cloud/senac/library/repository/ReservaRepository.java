package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("""
            SELECT a FROM Reserva a WHERE a.usuario.id = :usuarioId ORDER BY dataInicial DESC
            """)
    List<Reserva> findReservaByUsuarioId(Long usuarioId);

}
