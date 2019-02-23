package com.fsma.app.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsma.app.entities.Registro;
import com.fsma.app.repositories.RegistroRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RegistroServiceTest {
	
	@MockBean
	private RegistroRepository registroRepository;
	
	@Autowired
	private RegistroService registroService;
	
	private static final String NOME = "Joao Ricardo";
	private static final String EMAIL = "jrdutra_@msn.com";
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.registroRepository.findByNome(Mockito.anyString())).willReturn(new Registro());
		BDDMockito.given(this.registroRepository.findByEmail(Mockito.anyString())).willReturn(new Registro());
		BDDMockito.given(this.registroRepository.save(Mockito.any(Registro.class))).willReturn(new Registro());
	}
	
	@Test
	public void testBuscarRegistroPorNome() {
		Optional<Registro> registro = this.registroService.buscarPorNome(NOME);
		assertTrue(registro.isPresent());
	}
	
	@Test
	public void testBuscarRegistroPorEmail() {
		Optional<Registro> registro = this.registroService.buscarPorEmail(EMAIL);
		assertTrue(registro.isPresent());
	}
	
	@Test
	public void testPersistirRegistro() {
		Registro registro = this.registroService.persistir(new Registro());
		assertNotNull(registro);
	}
}
