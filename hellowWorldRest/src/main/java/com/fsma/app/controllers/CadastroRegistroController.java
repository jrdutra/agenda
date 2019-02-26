package com.fsma.app.controllers;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsma.app.services.RegistroService;

@RestController
@RequestMapping("/api/cadastroRegistro")
@CrossOrigin(origins="*")
public class CadastroRegistroController {
	
		private static final Logger log = (Logger) LoggerFactory.getLogger(CadastroRegistroController.class);
		
		@Autowired
		private RegistroService registroService;
		
		public CadastroRegistroController() {
			
		}
		
		
}
