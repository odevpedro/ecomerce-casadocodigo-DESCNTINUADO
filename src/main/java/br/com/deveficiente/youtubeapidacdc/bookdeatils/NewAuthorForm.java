package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.hibernate.validator.constraints.URL;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

public class NewAuthorForm {
    @NotBlank
    private String nome;

    @NotBlank
    @URL
    private String linkGithub;

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }
    public Author newAuthor(){
        return new Author(nome, linkGithub);
    }
}
