package br.com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.model.Alunos.Sexo;
import br.com.academia.model.Alunos.Situacao;
import br.com.academia.model.Estados;
import br.com.academia.repository.EstadosRepository;

@Service
public class DataService {

	@Autowired
	private EstadosRepository estadosRepository;
	
	public List<Estados> listEstados() {
		return estadosRepository.listaEstados();
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
}
