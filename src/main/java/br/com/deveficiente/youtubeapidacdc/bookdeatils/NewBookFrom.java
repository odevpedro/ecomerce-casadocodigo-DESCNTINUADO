package br.com.deveficiente.youtubeapidacdc.bookdeatils;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.function.Function;

public class NewBookFrom {
    @NotBlank
    @Size(max = 100)
    public String titulo;
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
    @NotNull
    private MultipartFile capa;

    @NotNull
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

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

    public MultipartFile getCapa() {
        return capa;
    }

    public void setCapa(MultipartFile capa) {
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

    public Book newBook(AuthorRepository authorRepository, Uploader uploader){
        Author author = authorRepository.findById(authorId).get();
        String linkCapaLivro = uploader.upload(capa);
        return new Book(titulo, subTitulo, preco, conteudo, sumario, numeroPaginas, isbn, linkCapaLivro, author);
    }
}
