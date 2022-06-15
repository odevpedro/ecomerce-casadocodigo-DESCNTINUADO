package br.com.deveficiente.youtubeapidacdc.bookdeatils;

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
        NewBookFrom form = (NewBookFrom) target;
        String title = form.getTitulo();

        Optional<Book> possivelLivro = repository.findByTitulo(title);
        if (possivelLivro.isPresent()){
            errors.rejectValue("titulo", null, "Já existe um livro com esse titulo");
        }

    }
}
