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

import com.example.floreria.modelos.Flor;
import com.example.floreria.servicios.FlorServicioImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FlorControlador {
	
	@Autowired
	FlorServicioImpl florservicio;
	
	@GetMapping("/flor")
	public List<Flor>obtenerFlor(){
		return florservicio.obtenerTodo();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Flor> guardarFlor(@RequestBody Flor flor){
		Flor nuevo_flor = florservicio.guardar(flor);
		return new ResponseEntity<>(nuevo_flor, HttpStatus.CREATED);	
	}
	
	@GetMapping("/flor/{id}")
	public ResponseEntity<Flor>obtenerFlorId(@PathVariable long id){
		Flor florPortId = florservicio.obtenerPortId(id);
		return ResponseEntity.ok(florPortId);
	}
	
	@PutMapping("flor/{id}")
	public ResponseEntity<Flor> actualizar(@PathVariable long id,@RequestBody Flor flor){
		Flor florPortId = florservicio.obtenerPortId(id);
		florPortId.setNombre(flor.getNombre());
		florPortId.setPrecio(flor.getPrecio());
		florPortId.setStock(flor.getStock());
		
		Flor flor_actualizado = florservicio.guardar(florPortId);
		return new ResponseEntity<>(flor_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/flor/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarFlor(@PathVariable long id) {
		this.florservicio.eliminar(id);
		HashMap<String, Boolean> estadoFlorEliminado = new HashMap<>();
		estadoFlorEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoFlorEliminado);
	}
}
