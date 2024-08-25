package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Autor;
import com.cloud.senac.library.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
        select a from Usuario a WHERE a.nome ilike :nome
        """)
    List<Usuario> findUsuarioByName(String nome);
}
