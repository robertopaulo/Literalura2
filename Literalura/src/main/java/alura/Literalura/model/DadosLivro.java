package alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosLivro{
        private Long id;
        @JsonAlias("title") private String titulo;
        @JsonAlias("languages") private List<String> idiomas;
        @JsonAlias("download_count") private int numeroDownloads;
        private List<Autor> authors;

        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }
        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }
        public List<Autor> getAutor() {
                return authors;
        }

        public void setAutor(List<Autor> authors) {
                this.authors = authors;
        }

        public List<String> getIdiomas() {
                return idiomas;
        }

        public void setIdiomas(List<String> idiomas) {
                this.idiomas = idiomas;
        }
        public int getNumeroDownloads() {
                return numeroDownloads;
        }

        public void setNumeroDownloads(int numeroDownloads) {
                this.numeroDownloads = numeroDownloads;
        }
}