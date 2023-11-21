package com.example.floreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.floreria.modelos.Flor;
import com.example.floreria.repositorios.FlorRepositorio;

@Service
public class FlorServicioImpl implements IFlorServicios{
	
	@Autowired
	FlorRepositorio florrepositorio;

	@Override
	public List<Flor> obtenerTodo() {
		// TODO Auto-generated method stub
		return florrepositorio.findAll();
	}

	@Override
	public Flor guardar(Flor flor) {
		// TODO Auto-generated method stub
		return florrepositorio.save(flor);
	}

	@Override
	public Flor obtenerPortId(long id) {
		// TODO Auto-generated method stub
		return florrepositorio.findById(id).orElseGet(null);
	}

	@Override
	public void eliminar(long id) {
		florrepositorio.deleteById(id);		
	}

}
