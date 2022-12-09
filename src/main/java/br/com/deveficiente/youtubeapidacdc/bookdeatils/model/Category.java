package br.com.deveficiente.youtubeapidacdc.bookdeatils.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Category(@NotBlank String nome){
        super();
        this.nome = nome;

    }

    Category(){}

}
