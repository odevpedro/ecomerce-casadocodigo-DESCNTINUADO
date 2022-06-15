package br.com.deveficiente.youtubeapidacdc.bookdeatils;

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

        return NewBookFrom.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewBookFrom form = (NewBookFrom) target;
        String isbn = form.getIsbn();

        Optional<Book> possivelLivro = repository.findByIsbn(isbn);
        if (possivelLivro.isPresent()){
            errors.rejectValue("isbn", null, "Já existe um livro com esse isbn");
        }

    }
}
