package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudBookController {

    @Autowired
    private AuthorRepository autorRepository;
    @Autowired
    private Uploader uploader;
    @Autowired
    private BookRepository repository;

    @PostMapping(value = "/api/livro")
    @Transactional
    public  void novo(@Valid @RequestBody NewBookFrom form){
       Book book = form.newBook(autorRepository, uploader);
       repository.save(book);
       System.out.println(book);

    }
}
