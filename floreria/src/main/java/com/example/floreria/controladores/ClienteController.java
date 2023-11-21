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

import com.example.floreria.modelos.Cliente;
import com.example.floreria.servicios.ClienteServicioImpl;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")

public class ClienteController {

    @Autowired
    ClienteServicioImpl clienteservicio;
    
    @GetMapping("/cliente")
    public List<Cliente>obtenerCliente(){
        return clienteservicio.obtenerTodo();
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
        Cliente nuevo_cliente = clienteservicio.guardar(cliente);
        return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);    
    }
    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente>obtenerClienteId(@PathVariable long id){
        Cliente clientePortId = clienteservicio.obtenerPortId(id);
        return ResponseEntity.ok(clientePortId);
    }
    
    @PutMapping("cliente/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable long id,@RequestBody Cliente cliente){
        Cliente clientePortId = clienteservicio.obtenerPortId(id);
        clientePortId.setNombre(cliente.getNombre());
        clientePortId.setApellido(cliente.getApellido());
        clientePortId.setEmail(cliente.getEmail());
        clientePortId.setTelefono(cliente.getTelefono());
        
        Cliente cliente_actualizado = clienteservicio.guardar(clientePortId);
        return new ResponseEntity<>(cliente_actualizado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id) {
        this.clienteservicio.eliminar(id);
        HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();
        estadoClienteEliminado.put("eliminado", true);
        return ResponseEntity.ok(estadoClienteEliminado);
    }
    
    
}
