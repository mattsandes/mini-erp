package br.com.sandes.data.DTOs;

public record ProductDTO(
		Long id,
		String name,
		String productCode,
		Double price,
		String unit,
		String description) {}
