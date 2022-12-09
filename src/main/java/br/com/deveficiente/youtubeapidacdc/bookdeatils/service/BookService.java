package br.com.deveficiente.youtubeapidacdc.bookdeatils.service;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

}
