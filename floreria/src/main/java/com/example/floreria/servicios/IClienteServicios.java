package com.example.floreria.servicios;

import java.util.List;

import com.example.floreria.modelos.Cliente;

public interface IClienteServicios {

	public List<Cliente> obtenerTodo();
    
    public Cliente guardar(Cliente cliente);
    
    public Cliente obtenerPortId(long id);
    
    public void eliminar(long id);
}
