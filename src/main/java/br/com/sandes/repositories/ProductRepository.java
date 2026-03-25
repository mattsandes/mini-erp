package br.com.sandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sandes.data.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}
