package br.com.deveficiente.youtubeapidacdc.bookdeatils.repository;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitulo(String title);


}
