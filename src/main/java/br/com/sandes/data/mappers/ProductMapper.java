package br.com.sandes.data.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.sandes.data.Product;
import br.com.sandes.data.DTOs.CreateProductDTO;
import br.com.sandes.data.DTOs.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
		
	ProductDTO entityToDto(Product product);

	Product dtoToEntity(ProductDTO dto);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "productName", target = "name")
	@Mapping(source = "productCode", target = "productCode")
	Product dtoToEntity(CreateProductDTO dto);
}
