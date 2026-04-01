package br.com.sandes.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sandes.data.Customer;
import br.com.sandes.data.DTOs.CreateCustomerDTO;
import br.com.sandes.data.DTOs.CustomersDTO;
import br.com.sandes.data.enums.CustomerTypes;
import br.com.sandes.data.mappers.CustomerMapper;
import br.com.sandes.repositories.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServicesTests {
	
	@Mock
	protected CustomerMapper mapper;
	
	@Mock
	private CustomerRepository repository;

	@InjectMocks
	private CustomerService service;
	
	@Test
	@DisplayName("Validate that is possible to list all the created customers")
	void givenAProductList_whenFindAllCustomers_thenTheCustomersListIsDisplayed() {
		List<CustomersDTO> customers = service.findAll();
		
		assertNotNull(customers);
	}
	
	@Test
	@DisplayName("Validate that is possible to create a customer")
	void givenCreateCustomerMethod_whenCreateANewCustomer_thenANewCustomerIsCreated() {
		Customer customer = new Customer(
				1L,
				"Test Customer",
				"123.456.789-10",
				"mateus.sandes@aidenti.com",
				"81997842487",
				CustomerTypes.FISICAL,
				"Cliente criado para testar os testes"
		);
		
		CreateCustomerDTO dto = new CreateCustomerDTO(
				"Test Customer",
				"123.456.789-10",
				"mateus.sandes@aidenti.com",
				"81997842487",
				CustomerTypes.FISICAL,
				"Cliente criado para testar os testes");
		
		CustomersDTO customerDTO = new CustomersDTO(
	            1L,
	            "Test Customer",
	            "123.456.789-10",
	            "81997842487",
	            "mateus.sandes@aidenti.com",
	            CustomerTypes.FISICAL,
	            "Cliente criado para testar os testes"
	    );
		
		when(repository.existsByCpf(customer.getCpf())).thenReturn(false);
		when(mapper.dtoToEntity(dto)).thenReturn(customer);
		when(mapper.entityToDto(customer)).thenReturn(customerDTO);
		when(repository.save(customer)).thenReturn(customer);
		
		var createdCustomer = service.createCustomer(dto);
		
		assertNotNull(createdCustomer);
		assertEquals(1L, createdCustomer.id());
	}
	
	@Test
	@DisplayName("Validate that is possible to find a customer by his id")
	void givenACreateUser_whenSearchedByHisId_thenTheCustomerIsListed() {
		Customer customer = new Customer(
				1L,
				"Test Customer",
				"123.456.789-10",
				"mateus.sandes@aidenti.com",
				"81997842487",
				CustomerTypes.FISICAL,
				"Cliente criado para testar os testes"
		);
		
		CustomersDTO customerDTO = new CustomersDTO(
	            1L,
	            "Test Customer",
	            "123.456.789-10",
	            "81997842487",
	            "mateus.sandes@aidenti.com",
	            CustomerTypes.FISICAL,
	            "Cliente criado para testar os testes"
	    );
		
		when(repository.findById(customer.getId()))
			.thenReturn(Optional.of(customer));
		
		when(mapper.entityToDto(customer)).thenReturn(customerDTO);
		
		var foundCustomer = service.findCustomerById(1L);
		
		assertNotNull(foundCustomer);
	}
}
