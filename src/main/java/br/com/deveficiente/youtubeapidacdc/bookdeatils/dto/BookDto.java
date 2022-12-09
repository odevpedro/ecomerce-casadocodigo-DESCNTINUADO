package br.com.deveficiente.youtubeapidacdc.bookdeatils.dto;

import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Author;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.model.Book;
import br.com.deveficiente.youtubeapidacdc.bookdeatils.repository.AuthorRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class BookDto {



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


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(BigDecimal numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }


    @Override
    public String toString() {
        return "NewBookFrom{" +
                "titulo='" + titulo + '\'' +
                ", subTitulo='" + subTitulo + '\'' +
                ", preco=" + preco +
                ", conteudo='" + conteudo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", capa=" + capa +
                '}';
    }



    //Constructor
    public BookDto(String titulo, String subTitulo, BigDecimal preco, String conteudo, String sumario, BigDecimal numeroPaginas, String isbn, String capa) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.capa = capa;
    }
}
