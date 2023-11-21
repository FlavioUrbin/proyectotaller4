package com.example.floreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.floreria.modelos.Cliente;
import com.example.floreria.repositorios.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements IClienteServicios{
	
	@Autowired
    ClienteRepositorio clienterepositorio;

    @Override
    public List<Cliente> obtenerTodo() {
        // TODO Auto-generated method stub
        return clienterepositorio.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        // TODO Auto-generated method stub
        return clienterepositorio.save(cliente);
    }

    @Override
    public Cliente obtenerPortId(long id) {
        // TODO Auto-generated method stub
        return clienterepositorio.findById(id).orElseGet(null);
    }

    @Override
    public void eliminar(long id) {
    	clienterepositorio.deleteById(id);     
    }
	
}
