package com.fsma.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsma.app.entities.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
	
	
	Registro findByNome(String nome);
	
	Registro findByEmail(String email);
	
	Registro findByNomeOrEmail(String nome, String email);
	
}
