package com.example.floreria.servicios;

import java.util.List;

import com.example.floreria.modelos.Detallepedido;

public interface IDetallepedidoServicios {
	public List<Detallepedido> obtenerTodo();
    
    public Detallepedido guardar(Detallepedido detallepedido);
    
    public Detallepedido obtenerPortId(long id);
    
    public void eliminar(long id);
}
