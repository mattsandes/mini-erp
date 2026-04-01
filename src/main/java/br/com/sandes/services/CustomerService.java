package br.com.sandes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sandes.data.Customer;
import br.com.sandes.data.DTOs.CreateCustomerDTO;
import br.com.sandes.data.DTOs.CustomersDTO;
import br.com.sandes.data.mappers.CustomerMapper;
import br.com.sandes.exceptions.DuplicatedRecordCodeException;
import br.com.sandes.exceptions.EmptyPathVariableException;
import br.com.sandes.exceptions.ResourceNotFoundException;
import br.com.sandes.repositories.CustomerRepository;

@Service
public class CustomerService {

	protected CustomerMapper mapper;
	private CustomerRepository repository;

	public CustomerService(
			CustomerMapper mapper,
			CustomerRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public List<CustomersDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(mapper::entityToDto)
				.toList();
	}
	
	public CustomersDTO createCustomer(CreateCustomerDTO dto) {
		boolean foundcustomer = repository.existsByCpf(dto.cpf());
		
		if(foundcustomer) {
			throw new DuplicatedRecordCodeException();
		}
		
		Customer customerEntity = mapper.dtoToEntity(dto);
		
		repository.save(customerEntity);
		
		return mapper.entityToDto(customerEntity);
	}
	
	public CustomersDTO findCustomerById(Long id) {
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		
		return mapper.entityToDto(customer);
	}
	
	public CustomersDTO updateCustomer(Long id, CreateCustomerDTO dto) {
		if(id == null) {
			throw new EmptyPathVariableException();
		}
		
		var foundCustomer = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		
		foundCustomer.setCustomerName(dto.name());
		foundCustomer.setCpf(dto.cpf());
		foundCustomer.setEmail(dto.email());
		foundCustomer.setTelefone(dto.telefone());
		foundCustomer.setObservations(dto.observations());
		foundCustomer.setType(dto.type());
		
		repository.save(foundCustomer);
		
		return mapper.entityToDto(foundCustomer);
	}
	
	public void deleteCustomer(Long id) {
		if(id == null) {
			throw new EmptyPathVariableException();
		}
		
		repository.deleteById(id);
	}
}
