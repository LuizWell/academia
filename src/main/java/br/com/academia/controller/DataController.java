package br.com.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academia.model.Alunos.Sexo;
import br.com.academia.model.Alunos.Situacao;
import br.com.academia.service.DataService;

@Controller
@RestController
@RequestMapping(value = "/")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping(value = "/estado")
	public List<?> estado(){
		return dataService.listEstados();
	}
	
	@GetMapping(value = "/sexo")
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}

	@GetMapping(value = "/situacao")
	public Situacao[] getSituacoes() {
		return dataService.getSituacoes();
	}

}
