package com.example.floreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.floreria.modelos.Pedido;
import com.example.floreria.repositorios.PedidoRepositorio;

@Service
public class PedidoServicioImpl implements IPedidoServicios{
	@Autowired
    PedidoRepositorio pedidorepositorio;

    @Override
    public List<Pedido> obtenerTodo() {
        // TODO Auto-generated method stub
        return pedidorepositorio.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        // TODO Auto-generated method stub
        return pedidorepositorio.save(pedido);
    }

    @Override
    public Pedido obtenerPortId(long id) {
        // TODO Auto-generated method stub
        return pedidorepositorio.findById(id).orElseGet(null);
    }

    @Override
    public void eliminar(long id) {
    	pedidorepositorio.deleteById(id);     
    }
}
