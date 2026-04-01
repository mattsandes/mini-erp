package br.com.sandes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Mini-ERP API")
						.version("1.0")
						.description("API criada para o projeto Mini-ERP")
						.termsOfService("https://www.google.com.br")
						.license(
								new License()
								.name("Apache 2.0")
								.url("https://www,google.com.br")));
	}
}
