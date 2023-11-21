package com.example.floreria.servicios;

import java.util.List;

import com.example.floreria.modelos.Flor;

public interface IFlorServicios {

	
	public List<Flor> obtenerTodo();
	
	public Flor guardar(Flor flor);
	
	public Flor obtenerPortId(long id);
	
	public void eliminar(long id);
	
	
}
