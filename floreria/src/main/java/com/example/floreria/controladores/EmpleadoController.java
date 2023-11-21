package com.example.floreria.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.floreria.modelos.Empleado;
import com.example.floreria.servicios.EmpleadoServicioImpl;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin("*")

public class EmpleadoController {
	@Autowired
    EmpleadoServicioImpl empleadoservicio;
    
    @GetMapping("/empleado")
    public List<Empleado>obtenerEmpleado(){
        return empleadoservicio.obtenerTodo();
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
    	Empleado nuevo_empleado = empleadoservicio.guardar(empleado);
        return new ResponseEntity<>(nuevo_empleado, HttpStatus.CREATED);    
    }
    
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado>obtenerEmpleadoId(@PathVariable long id){
    	Empleado empleadoPortId = empleadoservicio.obtenerPortId(id);
        return ResponseEntity.ok(empleadoPortId);
    }
    
    @PutMapping("empleado/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable long id,@RequestBody Empleado empleado){
    	Empleado empleadoPortId = empleadoservicio.obtenerPortId(id);
    	empleadoPortId.setNombre(empleado.getNombre());
    	empleadoPortId.setApellido(empleado.getApellido());
    	empleadoPortId.setDireccion(empleado.getDireccion());
        
        
        Empleado empleado_actualizado = empleadoservicio.guardar(empleadoPortId);
        return new ResponseEntity<>(empleado_actualizado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEmpleado(@PathVariable long id) {
        this.empleadoservicio.eliminar(id);
        HashMap<String, Boolean> estadoEmpleadoEliminado = new HashMap<>();
        estadoEmpleadoEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoEmpleadoEliminado);
    }
}
