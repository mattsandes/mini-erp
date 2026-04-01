package br.com.sandes.data.DTOs;

import org.hibernate.validator.constraints.Length;

import br.com.sandes.data.enums.CustomerTypes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerDTO(
		
		@NotBlank(message = "Customer name is mandatory")
		String name,
		
		@NotBlank(message = "Customer CPF is mandatory")
		String cpf,
		
		@NotBlank(message = "Customer telefone is mandatory")
		@Length(max = 20)
		String telefone,
		
		@Email
		@NotBlank(message = "Customer email is mandatory")
		String email,
		
		@NotNull(message = "Customer type is mandatory")
		CustomerTypes type,
		
		@Length(max = 255)
		String observations
		) {
}
