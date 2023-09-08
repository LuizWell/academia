package br.com.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.repository.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;

}
