package com.cloud.senac.library.adapter.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Object {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomeAutor;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livroList;


}
