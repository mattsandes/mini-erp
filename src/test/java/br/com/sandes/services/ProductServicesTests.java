package br.com.sandes.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sandes.data.DTOs.CreateProductDTO;
import br.com.sandes.data.DTOs.ProductDTO;
import br.com.sandes.data.mappers.ProductMapper;
import br.com.sandes.repositories.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTests {
	
	@Mock
	protected ProductMapper mapper;
	
	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductService productService;

	@Test
	@DisplayName("Validate that when there is no created product then getAllProduct bring a empty list")
	void givenProductProudctList_whenCallsMethod_thenReturnAllProducts() {
		var products = productService.findAllProducts();
		
		assertEquals(products, List.of());
	}
	
	@Test
	@DisplayName("Validate that is possible to create a product")
	void givenAProduct_whenCreateAProduct_thenTheProductIsCreatedSuccessfully() {
		CreateProductDTO dot = new CreateProductDTO(
				"Test Product",
				"CODPRODTST-01",
				100.0,
				"Produto Test",
				"Kg");
		
		ProductDTO product = new ProductDTO(
				1L,
				"Test Proudct",
				"CODPRODTST-01",
				100.0,
				"kg",
				"Produto Test");
		
		when(productService.createProduct(dot)).thenReturn(product);
				
		var createdProduct = productService.createProduct(dot);
				
		assertNotNull(createdProduct);
		assertEquals(createdProduct.description(), "Produto Test");
	}
}
