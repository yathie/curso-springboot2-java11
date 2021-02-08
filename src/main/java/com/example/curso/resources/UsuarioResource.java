package com.example.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario usuario1 =  new Usuario(1L, "Jimmy", "ji@gmail.com", "9999999999", "123");
		return ResponseEntity.ok().body(usuario1);
	}

}
