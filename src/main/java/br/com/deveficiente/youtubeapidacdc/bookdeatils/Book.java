package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.hibernate.validator.constraints.URL;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String titulo;
    @NotBlank
    @Size(max = 50)
    private String subTitulo;
    @Min(20)
    private BigDecimal preco;
    @NotBlank
    private String conteudo;
    @NotBlank
    private String sumario;
    @Min(100)
    private BigDecimal numeroPaginas;
    @NotBlank
    private String isbn;
    @NotBlank @URL
    private String linkCapaLivro;

    @ManyToOne
    private @NotNull Author autor;

    public Book(@NotBlank String titulo, @NotBlank @Size(max = 50)String subTitulo, @Min(20)BigDecimal preco, @NotBlank String conteudo, @NotBlank String sumario, @Min(100) BigDecimal numeroPaginas, @NotBlank String isbn, @NotBlank @URL String linkCapaLivro, @NotNull Author author) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.linkCapaLivro = linkCapaLivro;
        this.autor = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "titulo='" + titulo + '\'' +
                ", subTitulo='" + subTitulo + '\'' +
                ", preco=" + preco +
                ", conteudo='" + conteudo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", linkCapaLivro='" + linkCapaLivro + '\'' +
                ", autor=" + autor +
                '}';
    }
}
