package br.com.deveficiente.youtubeapidacdc.controller;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.dto.BookDto;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.AuthorRepository;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.BookRepository;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.lang.reflect.Type;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorRepository autorRepository;
    private final BookRepository repository;
    private final ModelMapper modelMapper;

    public BookController(BookService bookService, AuthorRepository autorRepository, BookRepository repository, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.autorRepository = autorRepository;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @PostMapping(value = "/api/livro")
    @Transactional
    public Book novo(@RequestBody @Valid BookDto dto){
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        System.out.println(book);
        return bookService.save(book);



    }
}
