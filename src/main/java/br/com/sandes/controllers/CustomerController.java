package br.com.sandes.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandes.data.DTOs.CreateCustomerDTO;
import br.com.sandes.data.DTOs.CustomersDTO;
import br.com.sandes.services.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController{
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomersDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomersDTO findById(@PathVariable Long id) {
		return service.findCustomerById(id);
	}
	
	@PostMapping(
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomersDTO createCustomer(@RequestBody @Valid CreateCustomerDTO dto) {
		return service.createCustomer(dto);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value = "/{id}")
	public CustomersDTO updateCostumer(
			@PathVariable Long id,
			@RequestBody CreateCustomerDTO dto) {
		
		return service.updateCustomer(id, dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
		
		return ResponseEntity.noContent()
				.build();
	}
}
