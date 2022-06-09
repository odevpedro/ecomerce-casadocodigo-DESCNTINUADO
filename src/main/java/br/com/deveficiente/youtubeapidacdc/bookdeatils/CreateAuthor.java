package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CreateAuthor {


    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/api/autor")
    @Transactional
    public void novo(@Valid @RequestBody NewAuthorForm authorForm) {
       Author newAuthor =  authorForm.newAuthor();
        System.out.println(newAuthor);
        manager.persist(newAuthor);
    }
}
