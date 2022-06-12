package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    private @NotBlank @URL String linkGithub;

    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    public Author(@NotBlank String nome, @NotBlank @URL String linkGithub) {
        this.nome = nome;
        this.linkGithub = linkGithub;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", linkGithub='" + linkGithub + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    Author(){

    }
}
