package com.fsma.app.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsma.app.entities.Registro;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RegistroRepositoryTest {
	
	@Autowired
	private RegistroRepository registroRepository;
	
	private static final String NOME = "Joao Ricardo Core Dutra";
	private static final String EMAIL = "jrdutra_@msn.com";
	
	@Before
	public void setUp() throws Exception{
		Registro registro = new Registro();
		registro.setNome(NOME);
		registro.setEmail(EMAIL);
		registro.setTelefone("22997634093");
		
		this.registroRepository.save(registro);
	}
	
	@After
	public final void tearDow() {
		this.registroRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorNome() {
		Registro registro = this.registroRepository.findByNome(NOME);
		
		assertEquals(NOME, registro.getNome());
	}
	
	@Test
	public void testBuscarPorEmail() {
		Registro registro = this.registroRepository.findByEmail(EMAIL);
		
		assertEquals(EMAIL, registro.getEmail());
	}
	
	@Test
	public void testBuscarPorNomeOuEmail() {
		Registro registro = this.registroRepository.findByNomeOrEmail(NOME, EMAIL);
		
		assertEquals(NOME, registro.getNome());
		assertEquals(EMAIL, registro.getEmail());
	}
}
