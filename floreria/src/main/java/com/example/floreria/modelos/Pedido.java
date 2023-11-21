package com.example.floreria.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int id_cliente;
    private String estadopedido;
    
    
    public Pedido() {
        
    }


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getEstadopedido() {
		return estadopedido;
	}


	public void setEstadopedido(String estadopedido) {
		this.estadopedido = estadopedido;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
