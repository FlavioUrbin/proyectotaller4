package com.example.floreria.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.floreria.modelos.Detallepedido;

@Repository
public interface DetallepedidoRepositorio extends JpaRepository<Detallepedido, Long>{

}
