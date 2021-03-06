package com.example.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Usuario;
import com.example.curso.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	//public ResponseEntity<Usuario> findAll(){
	public ResponseEntity<List<Usuario>> findAll(){
		//Usuario usuario1 =  new Usuario(1L, "Jimmy", "ji@gmail.com", "9999999999", "123");
		
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
