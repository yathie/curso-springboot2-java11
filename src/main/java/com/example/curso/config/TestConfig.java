package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Category;
import com.example.curso.entities.Pedido;
import com.example.curso.entities.Product;
import com.example.curso.entities.Usuario;
import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.repositories.CategoryRepositorio;
import com.example.curso.repositories.PedidoRepositorio;
import com.example.curso.repositories.ProductRepositorio;
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
	
	@Autowired
	private ProductRepositorio productRepo; 
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product	 p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product	 p5	 =	 new Product(null,	 "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.CANCELED);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.SHIPPED);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

		usuarioRepo.saveAll(Arrays.asList(u1, u2));
		pedidoRepo.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}
