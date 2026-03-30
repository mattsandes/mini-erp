package br.com.sandes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandes.data.DTOs.CreateProductDTO;
import br.com.sandes.data.DTOs.ProductDTO;
import br.com.sandes.services.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ProductDTO> getAllProduct() {
		return productService.findAllProducts();
	}
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody @Valid CreateProductDTO dto) {
		return productService.createProduct(dto);
	}
}
