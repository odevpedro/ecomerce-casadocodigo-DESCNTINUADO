package br.com.deveficiente.youtubeapidacdc.bookdeatils.repository;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByNome(String nome);
}
