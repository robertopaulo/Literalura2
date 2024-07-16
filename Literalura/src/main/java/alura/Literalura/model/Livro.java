package alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Livro {
    private int id;
    @JsonAlias("title") private String titulo;
    @JsonAlias("authors") private List<Autor> autor;
    @JsonAlias("languages") private List<String> idiomas;
    @JsonAlias("download_count")private int numeroDownloads;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> authors) {
        this.autor = authors;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> languages) {
        this.idiomas = languages;
    }

    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int download_count) {
        this.numeroDownloads = download_count;
    }
}
