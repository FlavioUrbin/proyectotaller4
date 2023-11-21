package com.example.floreria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.floreria.modelos.Empleado;
import com.example.floreria.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicios{
	@Autowired
    EmpleadoRepositorio empleadorepositorio;

    @Override
    public List<Empleado> obtenerTodo() {
        // TODO Auto-generated method stub
        return empleadorepositorio.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        // TODO Auto-generated method stub
        return empleadorepositorio.save(empleado);
    }

    @Override
    public Empleado obtenerPortId(long id) {
        // TODO Auto-generated method stub
        return empleadorepositorio.findById(id).orElseGet(null);
    }

    @Override
    public void eliminar(long id) {
    	empleadorepositorio.deleteById(id);     
    }
}
