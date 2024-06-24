package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Pruduct;

public interface ProductRepository extends JpaRepository<Pruduct, Long> {
	// Define custom query methods if needed
}