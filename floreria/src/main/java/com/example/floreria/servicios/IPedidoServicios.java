package com.example.floreria.servicios;

import java.util.List;

import com.example.floreria.modelos.Pedido;

public interface IPedidoServicios {
public List<Pedido> obtenerTodo();
    
    public Pedido guardar(Pedido pedido);
    
    public Pedido obtenerPortId(long id);
    
    public void eliminar(long id);
}
