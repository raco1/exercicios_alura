package com.example.exercicios.alura;

import com.example.exercicios.alura.repository.CategoriaRepository;
import com.example.exercicios.alura.repository.PedidoRepository;
import com.example.exercicios.alura.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;

	public static void main(String[] args) {
		SpringApplication.run(AluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal p = new Principal(produtoRepo, pedidoRepo, categoriaRepo);
		p.getMenu();
	}
}
