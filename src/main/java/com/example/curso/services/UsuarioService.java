package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Usuario;
import com.example.curso.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repo;
	
	//retorna todos os usuarios
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	//busca por id
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  repo.findById(id);
		return obj.get();
	}

}
