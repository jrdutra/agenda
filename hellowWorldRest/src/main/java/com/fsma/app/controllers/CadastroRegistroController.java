package com.fsma.app.controllers;

import java.security.NoSuchAlgorithmException;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsma.app.dtos.CadastroRegistroDto;
import com.fsma.app.entities.Registro;
import com.fsma.app.response.Response;
import com.fsma.app.services.RegistroService;

@RestController
@RequestMapping("/app/cadastro")
@CrossOrigin(origins="*")
public class CadastroRegistroController {
	
		private static final Logger log = (Logger) LoggerFactory.getLogger(CadastroRegistroController.class);
		
		@Autowired
		private RegistroService registroService;
		
		public CadastroRegistroController() {
			
		}
		
		/*
		 * Cadastra um registro no sistema
		 * 
		 * @param cadastroRegistroDto
		 * @param result
		 * @return ResponseEntity<Response<CadastroRegistroDto>>
		 * @throws NoSuchAlgorithmException
		 */
		
		@PostMapping
		public ResponseEntity<Response<CadastroRegistroDto>> cadastrar(@Valid @RequestBody CadastroRegistroDto cadastroRegistroDto, BindingResult result) throws NoSuchAlgorithmException{
			log.info("Cadastrando Registro: {}", cadastroRegistroDto.toString());
			
			Response<CadastroRegistroDto> response = new Response<CadastroRegistroDto>();
			
			validarDadosExistentes(cadastroRegistroDto, result);
			
			//Converter o Dto em Registro
			Registro registro = this.converterDtoParaRegistro(cadastroRegistroDto);
			
			if(result.hasErrors()) {
				log.error("Erro validando registro: {}", result.getAllErrors());
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			
			this.registroService.persistir(registro);
			
			response.setData(this.converterRegistroParaDto(registro));
			
			return ResponseEntity.ok(response);
		}

		/*
		 * Converter Registro para Dto
		 * 
		 * @param registro
		 * @return CadastroRegistroDto
		 */
		private CadastroRegistroDto converterRegistroParaDto(Registro registro) {
			CadastroRegistroDto cadastroRegistroDto = new CadastroRegistroDto();
			cadastroRegistroDto.setEmail(registro.getEmail());
			cadastroRegistroDto.setId(registro.getId());
			cadastroRegistroDto.setNome(registro.getNome());
			cadastroRegistroDto.setTelefone(registro.getTelefone());
			
			return cadastroRegistroDto;
		}

		/*
		 * Converter Dto para Registro
		 * 
		 * @param cadastroRegistroDto
		 * @return Registro
		 */
		private Registro converterDtoParaRegistro(@Valid CadastroRegistroDto cadastroRegistroDto) {
			Registro registro = new Registro();
			registro.setEmail(cadastroRegistroDto.getEmail());
			registro.setNome(cadastroRegistroDto.getNome());
			registro.setTelefone(cadastroRegistroDto.getTelefone());
			return registro;
		}

		/*
		 * Verifica se o telefone já existe no banco de dados
		 * 
		 * @param cadastroRegistroDto
		 * @param result
		 */
		private void validarDadosExistentes(@Valid CadastroRegistroDto cadastroRegistroDto, BindingResult result) {
			this.registroService.buscarPorTelefone(cadastroRegistroDto.getTelefone())
				.ifPresent(reg -> result.addError(new ObjectError("registro", "Telefone já existente")));
			
		}
}
