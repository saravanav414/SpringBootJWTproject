package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Pruduct;
import com.main.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Pruduct> getAllProducts() {
		return productRepository.findAll();
	}

	public Pruduct getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public boolean deleteProductById(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
