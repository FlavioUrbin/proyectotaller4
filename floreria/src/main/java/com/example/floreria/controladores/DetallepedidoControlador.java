package com.example.floreria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.floreria.modelos.Detallepedido;
import com.example.floreria.servicios.DetallepedidoServicioImpl;

@RestController
@RequestMapping("/api/v5")
@CrossOrigin("*")

public class DetallepedidoControlador {
	@Autowired
    DetallepedidoServicioImpl detallepedidoservicio;
    
    @GetMapping("/detallepedido")
    public List<Detallepedido>obtenerDetallepedido(){
        return detallepedidoservicio.obtenerTodo();
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Detallepedido> guardarDetallepedido(@RequestBody Detallepedido detallepedido){
    	Detallepedido nuevo_detallepedido = detallepedidoservicio.guardar(detallepedido);
        return new ResponseEntity<>(nuevo_detallepedido, HttpStatus.CREATED);    
    }
    
    @GetMapping("/detallepedido/{id}")
    public ResponseEntity<Detallepedido>obtenerDetallepedidoId(@PathVariable long id){
    	Detallepedido detallepedidoPortId = detallepedidoservicio.obtenerPortId(id);
        return ResponseEntity.ok(detallepedidoPortId);
    }
    
    @PutMapping("detallepedido/{id}")
    public ResponseEntity<Detallepedido> actualizar(@PathVariable long id,@RequestBody Detallepedido detallepedido){
    	Detallepedido detallepedidoPortId = detallepedidoservicio.obtenerPortId(id);
    	
    	detallepedidoPortId.setId_pedido(detallepedido.getId_pedido());
    	detallepedidoPortId.setId_flor(detallepedido.getId_flor());
    	detallepedidoPortId.setCantidad(detallepedido.getCantidad());
       
        
        
        
    	Detallepedido detallepedido_actualizado = detallepedidoservicio.guardar(detallepedidoPortId);
        return new ResponseEntity<>(detallepedido_actualizado, HttpStatus.CREATED);
    }
}
