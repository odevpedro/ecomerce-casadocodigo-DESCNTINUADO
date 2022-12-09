package br.com.deveficiente.youtubeapidacdc.bookdeatils.validator;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.dto.BookDto;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.BookRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class IsbnUniqueValidator implements Validator {
    private BookRepository repository;

    public IsbnUniqueValidator(BookRepository repository){
        this.repository = repository;
    }


    @Override
    public boolean supports(Class<?> clazz) {

        return BookDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto form = (BookDto) target;
        String isbn = form.getIsbn();

        Optional<Book> possivelLivro = repository.findByIsbn(isbn);
        if (possivelLivro.isPresent()){
            errors.rejectValue("isbn", null, "Já existe um livro com esse isbn");
        }

    }
}
