package com.cloud.senac.library.repository;

import com.cloud.senac.library.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
