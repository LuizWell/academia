package br.com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academia.ExceptionAcademia;
import br.com.academia.enuns.TipoAcesso;
import br.com.academia.service.AcessosService;

@Controller
@RestController
@RequestMapping(value = "/acessos")
public class AcessosController {
	
	@Autowired
	private AcessosService acessosService;
	
	@PostMapping(value = "/registrar") 
	public ResponseEntity<?> registrar(@RequestParam(name = "matricula",defaultValue = "null") String matricula, 
										@RequestParam(name = "rg",defaultValue = "null") String rg) {
		
		if(matricula.equals("null") && rg.equals("null")) {
			throw new ExceptionAcademia("É preciso fornecer a matrícula ou o RG do Aluno");
		}
		
		TipoAcesso tipoAcesso;
		
		try {
			tipoAcesso = acessosService.registrarAcesso(matricula, Integer.parseInt(rg));
		} catch (ExceptionAcademia e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		String msg;
		if (tipoAcesso == TipoAcesso.ENTRADA) {
			msg = "ENTRADA registrada!";
		} else if (tipoAcesso == TipoAcesso.SAIDA) {
			msg="SAÍDA registrada!";
		} else {
			msg = "Dados de registro de acesso inconsistente";
		}
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	 }

}
