package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
