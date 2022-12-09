package br.com.deveficiente.youtubeapidacdc.bookdeatils.model;

import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String titulo;

    @Column(nullable = false, unique = true, length = 10)
    private String subTitulo;

    @Column(nullable = false, unique = true, length = 10)
    private BigDecimal preco;

    @Column(nullable = false, unique = true, length = 10)
    private String conteudo;

    @Column(nullable = false, unique = true, length = 10)
    private String sumario;

    @Column(nullable = false, unique = true, length = 10)
    private BigDecimal numeroPaginas;

    @Column(nullable = false, unique = true, length = 10)
    private String isbn;

    @Column(nullable = false, unique = true, length = 10)
    private String capa;

    @ManyToOne
    private @NotNull Author autor;

    public Book(@NotBlank String titulo, @NotBlank @Size(max = 50) String subTitulo, @Min(20) BigDecimal preco, @NotBlank String conteudo, @NotBlank String sumario, @Min(100) BigDecimal numeroPaginas, @NotBlank String isbn, @NotBlank String capa, @NotNull Author author) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.autor = author;
        this.capa = capa;
    }


    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", subTitulo='" + subTitulo + '\'' +
                ", preco=" + preco +
                ", conteudo='" + conteudo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", capa='" + capa + '\'' +
                ", autor=" + autor +
                '}';
    }
}





