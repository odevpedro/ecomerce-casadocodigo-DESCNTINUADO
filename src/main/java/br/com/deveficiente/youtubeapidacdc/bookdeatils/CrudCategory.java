package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudCategory {

    @Autowired
    private CategoryRepository repository;

    //Não permitir categoria duplicada
    @InitBinder("newCategoryForm")
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(repository));
    }

    @PostMapping(value = "/api/categoria")
    @Transactional
    public void nova(@Valid @RequestBody NewCategoryForm form){
        Category newCategory = new Category(form.getNome());
        repository.save(newCategory);
    }


}
