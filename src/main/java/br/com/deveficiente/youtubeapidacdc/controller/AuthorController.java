package br.com.deveficiente.youtubeapidacdc.controller;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Author;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.AuthorRepository;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/api/autor")
    @Transactional
    public void novo(@Valid @RequestBody AuthorDto authorForm) {
       Author newAuthor =  authorForm.newAuthor();
        System.out.println(newAuthor);
        authorRepository.save(newAuthor);


    }
}
