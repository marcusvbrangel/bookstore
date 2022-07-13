package com.mvbr.bookstore;

import com.mvbr.bookstore.model.Categoria;
import com.mvbr.bookstore.model.Livro;
import com.mvbr.bookstore.repositories.CategoriaRepository;
import com.mvbr.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria01 = new Categoria(null, "Informática", "Livros de Informática");

        Livro livro01 =
                new Livro(null, "Clean Code", "Robert Martin", "lorem ipsum", categoria01);

        categoria01.getLivros().addAll(Arrays.asList(livro01));

        this.categoriaRepository.saveAll(Arrays.asList(categoria01));

        this.livroRepository.saveAll(Arrays.asList(livro01));

    }
}
