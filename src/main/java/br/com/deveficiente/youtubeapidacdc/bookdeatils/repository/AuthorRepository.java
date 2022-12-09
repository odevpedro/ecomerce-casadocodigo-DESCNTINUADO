package br.com.deveficiente.youtubeapidacdc.bookdeatils.repository;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {


}
