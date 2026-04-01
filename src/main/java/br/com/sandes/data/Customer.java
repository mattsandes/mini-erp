package br.com.sandes.data;

import java.util.Objects;

import br.com.sandes.data.enums.CustomerTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(
			length = 150,
			nullable = false)
	private String customerName;
	
	@Column(
			length = 18,
			nullable = false,
			unique = true)
	private String cpf;
	
	@Column(
			length = 100,
			nullable = false)
	private String email;
	
	@Column(
			length = 20,
			nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private CustomerTypes type;
	
	@Column(length = 255)
	private String observations;
	
	public Customer(Long id, String customerName, String cpf, String email, String telefone, CustomerTypes type,
			String observations) {
		this.id = id;
		this.customerName = customerName;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.type = type;
		this.observations = observations;
	}

	public Customer(String customerName, String cpf, String email, String telefone, CustomerTypes type,
			String observations) {
		super();
		this.customerName = customerName;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.type = type;
		this.observations = observations;
	}

	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public CustomerTypes getType() {
		return type;
	}

	public void setType(CustomerTypes type) {
		this.type = type;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, customerName, email, id, observations, telefone, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(customerName, other.customerName)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(observations, other.observations) && Objects.equals(telefone, other.telefone)
				&& type == other.type;
	}
}
