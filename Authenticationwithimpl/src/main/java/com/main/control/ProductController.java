package com.main.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Pruduct;
import com.main.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Boot Security";
	}

	// Inside ProductController class

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADIMN')")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		try {
			boolean deleted = productService.deleteProductById(id);
			if (deleted) {
				return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Failed to delete product", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasRole('ADIMN')")
	public ResponseEntity<Pruduct> fetchProduct(@PathVariable Long id) {
		Pruduct product = productService.getProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/fetch-all")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Pruduct>> fetchAllProducts() {
		List<Pruduct> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}