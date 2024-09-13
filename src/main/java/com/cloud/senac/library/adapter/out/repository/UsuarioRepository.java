package com.cloud.senac.library.adapter.out.repository;

import com.cloud.senac.library.adapter.out.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
        select a from Usuario a WHERE a.nome ilike :nome
        """)
    List<Usuario> findUsuarioByName(String nome);

    Optional<Usuario> findByEmail(String email);

}
