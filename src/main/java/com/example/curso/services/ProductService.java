package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Product;
import com.example.curso.repositories.ProductRepositorio;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositorio repo;
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	//busca por id
	public Product findById(Long id) {
		Optional<Product> obj =  repo.findById(id);
		return obj.get();
	}

}
