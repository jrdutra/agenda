package com.fsma.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CadastroRegistroDto {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
	public CadastroRegistroDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Length(min = 5, max = 200, message = "E deve conter entre 3 e 200 caracteres.")
	@Email(message="Email inválido")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message = "Telefone não pode ser vazio")
	@Length(min = 3, max = 30, message = "Telefone deve conter entre 3 e 30 caracteres.")
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "CadastroRegistroDto [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
	
}
