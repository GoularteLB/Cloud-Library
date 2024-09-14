package com.cloud.senac.library.core.domain;

import java.util.List;

public class Autor {

    private Long id;
    private String nomeAutor;
    private List<Livro> livroList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    public Autor(Long id, String nomeAutor, List<Livro> livroList) {
        this.id = id;
        this.nomeAutor = nomeAutor;
        this.livroList = livroList;
    }

    public Autor() {

    }

}
