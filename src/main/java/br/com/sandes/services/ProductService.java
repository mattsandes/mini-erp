package br.com.sandes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sandes.data.Product;
import br.com.sandes.data.DTOs.CreateProductDTO;
import br.com.sandes.data.DTOs.ProductDTO;
import br.com.sandes.data.mappers.ProductMapper;
import br.com.sandes.repositories.ProductRepository;

@Service
public class ProductService {

	protected ProductMapper mapper;
	private final ProductRepository repository;

	public ProductService(
			ProductMapper mapper,
			ProductRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public List<ProductDTO> findAllProducts() {
		var products = repository.findAll();
		
		List<ProductDTO> productListDTO = new ArrayList<>();
		
		for(var product : products) {
			var productDTO = mapper.entityToDto(product);
			
			productListDTO.add(productDTO);
		}
		
		return productListDTO;
	}
	
	public ProductDTO createProduct(CreateProductDTO dto) {
		
		Product product = mapper.dtoToEntity(dto);
		
		var createProduct = repository.save(product);
		
		return mapper.entityToDto(createProduct);
	}
}
