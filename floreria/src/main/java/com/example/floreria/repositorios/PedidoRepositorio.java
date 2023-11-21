package com.example.floreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.floreria.modelos.Pedido;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
