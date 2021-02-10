package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Category;
import com.example.curso.entities.Pedido;
import com.example.curso.entities.Usuario;
import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.repositories.CategoryRepositorio;
import com.example.curso.repositories.PedidoRepositorio;
import com.example.curso.repositories.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;

	@Autowired
	private PedidoRepositorio pedidoRepo;
	
	@Autowired
	private CategoryRepositorio categoryRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.CANCELED);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.SHIPPED);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

		usuarioRepo.saveAll(Arrays.asList(u1, u2));
		pedidoRepo.saveAll(Arrays.asList(o1, o2, o3));
	}

}
