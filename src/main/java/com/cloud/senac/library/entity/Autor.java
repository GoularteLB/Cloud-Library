package com.cloud.senac.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String nomeAutor;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livroList;


}
