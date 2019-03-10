package com.fsma.app.services;

import java.util.Optional;

import com.fsma.app.entities.Registro;

public interface RegistroService {

	/**
	 * Retorna um registro dado o nome
	 * 
	 * @param nome
	 * @return Optional<Registro>
	 */
	Optional<Registro> buscarPorNome(String nome);
	
	/**
	 * Retorna um registro dado o email
	 * 
	 * @param email
	 * @return Optional<Registro>
	 */
	Optional<Registro> buscarPorEmail(String email);
	
	/**
	 * Retorna um registro dado o telefone
	 * 
	 * @param telefone
	 * @return Optional<Registro>
	 */
	Optional<Registro> buscarPorTelefone(String telefone);
	
	/**
	 * Cadastra um nome registro
	 * 
	 * @param registro
	 * @return Registro
	 */
	Registro persistir(Registro registro);
	
}
