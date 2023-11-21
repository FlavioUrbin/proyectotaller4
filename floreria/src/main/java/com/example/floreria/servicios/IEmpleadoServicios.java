package com.example.floreria.servicios;

import java.util.List;

import com.example.floreria.modelos.Empleado;

public interface IEmpleadoServicios {
public List<Empleado> obtenerTodo();
    
    public Empleado guardar(Empleado empleado);
    
    public Empleado obtenerPortId(long id);
    
    public void eliminar(long id);
}
