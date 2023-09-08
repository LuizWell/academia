package br.com.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.repository.AcessosRepository;

@Service
public class AcessosService {
	
	@Autowired
	private AcessosRepository acessosRepository;

}
