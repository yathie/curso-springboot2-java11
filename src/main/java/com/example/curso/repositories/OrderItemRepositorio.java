package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.OrderItem;

public interface OrderItemRepositorio extends JpaRepository<OrderItem, Long>{

}
