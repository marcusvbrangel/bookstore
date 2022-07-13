package com.mvbr.bookstore.service;

import com.mvbr.bookstore.model.Categoria;
import com.mvbr.bookstore.model.Livro;
import com.mvbr.bookstore.repositories.CategoriaRepository;
import com.mvbr.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void carregarBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livros de Informática");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Livros de Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro liv1 = new Livro(null, "Clean Code", "Robert Martin", "Lore ipsum", cat1);
        Livro liv2 = new Livro(null, "Engenharia de Software", "Autor Eng. Soft.", "Lore ipsum", cat1);
        Livro liv3 = new Livro(null, "The Time Machine", "Auto Time Machine", "Lore ipsum", cat2);
        Livro liv4 = new Livro(null, "The War of the Worlds", "Autor War Worls", "Lore ipsum", cat2);
        Livro liv5 = new Livro(null, "I, Robot", "Autor isaac Asimov", "Lore ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(liv1, liv2));
        cat2.getLivros().addAll(Arrays.asList(liv3, liv4, liv5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        this.livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4, liv5));

    }
}
