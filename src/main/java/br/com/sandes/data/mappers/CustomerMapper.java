package br.com.sandes.data.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.sandes.data.Customer;
import br.com.sandes.data.DTOs.CreateCustomerDTO;
import br.com.sandes.data.DTOs.CustomersDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomersDTO entityToDto(Customer customer);
	
	Customer dtoToEntity(CustomersDTO dto);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "name", target = "customerName")
	Customer dtoToEntity(CreateCustomerDTO dto);
}
