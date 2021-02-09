package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Pedido;
import com.example.curso.repositories.PedidoRepositorio;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepositorio repo;
	
	//retorna todos os usuarios
	public List<Pedido> findAll(){
		return repo.findAll();
	}
	
	//busca por id
	public Pedido findById(Long id) {
		Optional<Pedido> obj =  repo.findById(id);
		return obj.get();
	}

}
