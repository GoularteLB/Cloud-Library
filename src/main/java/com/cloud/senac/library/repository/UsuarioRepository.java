package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Autor;
import com.cloud.senac.library.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
