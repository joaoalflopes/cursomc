package com.example.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Escolar");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto p1 = new Produto(null, "Impressora", 1200);
		Produto p2 = new Produto(null, "Notebook Asus i3", 1900);
		Produto p3 = new Produto(null, "Grampeador Mappe mini", 35.00);
		Produto p4 = new Produto(null, "Agendas Semanais", 18.00);
		Produto p5 = new Produto(null, "Tonner HP3450", 395.00);
		Produto p6 = new Produto(null, "Caderno Universitario 20Mat", 65.00);
		Produto p7 = new Produto(null, "Lapis Preto B2", 3.50);
		Produto p8 = new Produto(null, "Caneta Esferografica 1.0 Preta", 6.75);
		Produto p9 = new Produto(null, "Marca Texto VerdeLim", 9.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p5));
		cat2.getProdutos().addAll(Arrays.asList(p3,p4,p5,p9));
		cat3.getProdutos().addAll(Arrays.asList(p6,p7,p8,p9));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat2,cat3));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
		
		
	}
	

}
