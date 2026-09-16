package com.example.exercicios.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.exercicios.alura.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
