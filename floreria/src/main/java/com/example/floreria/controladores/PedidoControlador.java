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

import com.example.floreria.modelos.Pedido;
import com.example.floreria.servicios.PedidoServicioImpl;

@RestController
@RequestMapping("/api/v4")
@CrossOrigin("*")

public class PedidoControlador {
	@Autowired
    PedidoServicioImpl pedidoservicio;
    
    @GetMapping("/pedido")
    public List<Pedido>obtenerEmpleado(){
        return pedidoservicio.obtenerTodo();
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido){
        Pedido nuevo_pedido = pedidoservicio.guardar(pedido);
        return new ResponseEntity<>(nuevo_pedido, HttpStatus.CREATED);    
    }
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido>obtenerPedidoId(@PathVariable long id){
        Pedido pedidoPortId = pedidoservicio.obtenerPortId(id);
        return ResponseEntity.ok(pedidoPortId);
    }
    
    @PutMapping("pedido/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable long id,@RequestBody Pedido pedido){
        Pedido pedidoPortId = pedidoservicio.obtenerPortId(id);
        pedidoPortId.setId_cliente(pedido.getId_cliente());
        pedidoPortId.setEstadopedido(pedido.getEstadopedido());
        
        
        
        Pedido pedido_actualizado = pedidoservicio.guardar(pedidoPortId);
        return new ResponseEntity<>(pedido_actualizado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarPedido(@PathVariable long id) {
        this.pedidoservicio.eliminar(id);
        HashMap<String, Boolean> estadoPedidoEliminado = new HashMap<>();
        estadoPedidoEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoPedidoEliminado);
    }
    
}
