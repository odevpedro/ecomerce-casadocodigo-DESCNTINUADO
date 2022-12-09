package br.com.deveficiente.youtubeapidacdc.bookdeatils.validator;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.dto.CategoryDto;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Category;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.CategoryRepository;
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
        return CategoryDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryDto form = (CategoryDto) target;
        Optional<Category> possivelCategoria =  repository.findByNome(form.getNome());
        if (possivelCategoria.isPresent()){
            errors.rejectValue("nome", "400", "A categoria já existe");
        }
    }
}
