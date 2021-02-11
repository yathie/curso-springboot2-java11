package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.OrderItem;
import com.example.curso.repositories.OrderItemRepositorio;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepositorio repo;
	
	//retorna todos os usuarios
	public List<OrderItem> findAll(){
		return repo.findAll();
	}
	
	//busca por id
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj =  repo.findById(id);
		return obj.get();
	}

}
