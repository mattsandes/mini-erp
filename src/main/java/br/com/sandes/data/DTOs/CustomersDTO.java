package br.com.sandes.data.DTOs;

import br.com.sandes.data.enums.CustomerTypes;

public record CustomersDTO(
		Long id,
		String customerName,
		String cpf,
		String email,
		String telefone,
		CustomerTypes type,
		String observations) {

}
