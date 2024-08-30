package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("""
            SELECT l FROM Livro l WHERE l.titulo ILIKE :titulo
            """)
    List<Livro> findLivroByName(String titulo);

    @Modifying
    @Query("""
            UPDATE Livro l SET l.titulo = :titulo WHERE l.id = :id
            """)
    void updateLivroName(Long id, String titulo);
}
