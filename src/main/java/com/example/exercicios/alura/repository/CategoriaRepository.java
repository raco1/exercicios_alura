package com.example.exercicios.alura.repository;

import com.example.exercicios.alura.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
