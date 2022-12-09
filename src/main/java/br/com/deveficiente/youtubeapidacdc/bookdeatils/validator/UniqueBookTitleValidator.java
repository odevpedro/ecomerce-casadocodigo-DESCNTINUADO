package br.com.deveficiente.youtubeapidacdc.bookdeatils.validator;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.dto.BookDto;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.BookRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueBookTitleValidator implements Validator {
    public UniqueBookTitleValidator(BookRepository repository) {
    }

    private BookRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto form = (BookDto) target;
        String title = form.getTitulo();

        Optional<Book> possivelLivro = repository.findByTitulo(title);
        if (possivelLivro.isPresent()){
            errors.rejectValue("titulo", null, "Já existe um livro com esse titulo");
        }

    }
}
