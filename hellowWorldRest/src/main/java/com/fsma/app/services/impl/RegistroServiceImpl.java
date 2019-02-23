package com.fsma.app.services.impl;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsma.app.entities.Registro;
import com.fsma.app.repositories.RegistroRepository;
import com.fsma.app.services.RegistroService;

import ch.qos.logback.classic.Logger;

@Service
public class RegistroServiceImpl implements RegistroService {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(RegistroServiceImpl.class);

	@Autowired
	private RegistroRepository registroRepository;
	
	@Override
	public Optional<Registro> buscarPorNome(String nome){
		log.info("Buscando um registro para o nome {}", nome);
		return Optional.ofNullable(registroRepository.findByNome(nome));
	}
	
	@Override
	public Optional<Registro> buscarPorEmail(String email){
		log.info("Buscando um registro por email {}", email);
		return Optional.ofNullable(registroRepository.findByEmail(email));
	}
	
	@Override
	public Registro persistir(Registro registro) {
		log.info("Persisitir registro: {}", registro);
		return this.registroRepository.save(registro);
	}
}
