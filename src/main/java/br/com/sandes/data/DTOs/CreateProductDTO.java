package br.com.sandes.data.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProductDTO(
		
		@NotBlank(message = "Proudct name shouldn't empty")
		String productName,
		
		@NotBlank(message = "Product code is mandatory")
		String productCode,
		
		@NotNull(message = "Product price can't be null or negative")
		@Positive
		Double price,
		
		@NotBlank(message = "Product description can't be empty")
		String description,
		
		@NotEmpty(message = "Product unit is mandatory")
		String unit){

}
