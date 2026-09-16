package com.example.exercicios.alura.repository;

import com.example.exercicios.alura.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
