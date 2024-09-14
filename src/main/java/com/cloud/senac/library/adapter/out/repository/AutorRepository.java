package com.cloud.senac.library.adapter.out.repository;

import com.cloud.senac.library.adapter.out.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {


    @Modifying
    @Query("""
            UPDATE Autor a SET a.nomeAutor = :authorName WHERE a.id = :id
            """)
    void updateAuthorName(Long id, String authorName);

    @Query("""
            SELECT a FROM Autor a WHERE a.nomeAutor ILIKE :authorName
            """)
    List<Autor> listAuthorByName(String authorName);

}
