package com.trust.trustserver.controller;

import com.trust.trustserver.exception.ResourceNotFoundException;
import com.trust.trustserver.model.Product;
import com.trust.trustserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public Page<Product> getProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	@PutMapping("/products/{productId}")
	public Product updateProduct(@PathVariable Long productId,
								 @Valid @RequestBody Product productRequest) {
		return productRepository.findById(productId)
				.map(product -> {
                    product.setSummary(productRequest.getSummary());
					return productRepository.save(product);
				}).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
		return productRepository.findById(productId)
				.map(product -> {
					productRepository.delete(product);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
	}
}
