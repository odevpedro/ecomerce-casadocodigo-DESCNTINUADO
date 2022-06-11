package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


public class SemCategoriaComNomeDuplicadoValidator implements Validator {

    private CategoryRepository repository;

    public SemCategoriaComNomeDuplicadoValidator(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewCategoryForm form = (NewCategoryForm) target;
        Optional<Category> possivelCategoria =  repository.findByNome(form.getNome());
        if (possivelCategoria.isPresent()){
            errors.rejectValue("nome", "400", "A categoria já existe");
        }
    }
}
