package br.com.sandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sandes.data.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	boolean existsByCpf(String cpf);
}
