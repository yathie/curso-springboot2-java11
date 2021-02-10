package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Category;
import com.example.curso.repositories.CategoryRepositorio;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepositorio repo;
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	//busca por id
	public Category findById(Long id) {
		Optional<Category> obj =  repo.findById(id);
		return obj.get();
	}

}
