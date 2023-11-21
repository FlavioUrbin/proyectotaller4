package com.example.floreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.floreria.modelos.Detallepedido;
import com.example.floreria.repositorios.DetallepedidoRepositorio;

@Service
public class DetallepedidoServicioImpl implements IDetallepedidoServicios{
	@Autowired
    DetallepedidoRepositorio detallepedidorepositorio;

    @Override
    public List<Detallepedido> obtenerTodo() {
        // TODO Auto-generated method stub
        return detallepedidorepositorio.findAll();
    }

    @Override
    public Detallepedido guardar(Detallepedido detallepedido) {
        // TODO Auto-generated method stub
        return detallepedidorepositorio.save(detallepedido);
    }

    @Override
    public Detallepedido obtenerPortId(long id) {
        // TODO Auto-generated method stub
        return detallepedidorepositorio.findById(id).orElseGet(null);
    }

    @Override
    public void eliminar(long id) {
    	detallepedidorepositorio.deleteById(id);     
    }
}
