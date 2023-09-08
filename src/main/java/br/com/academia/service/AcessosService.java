package br.com.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.ExceptionAcademia;
import br.com.academia.enuns.TipoAcesso;
import br.com.academia.model.Acessos;
import br.com.academia.model.Alunos;
import br.com.academia.repository.AcessosRepository;
import br.com.academia.repository.AlunosRepository;
import br.com.academia.util.StringUtils;

@Service
public class AcessosService {
	
	@Autowired
	private AcessosRepository acessosRepository;
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public TipoAcesso registrarAcesso(String matricula, Integer rg) {
		if(matricula.equals("null") && rg == null) {
			throw new ExceptionAcademia("É preciso fornecer a matrícula ou o RG do Aluno");
		}
		
		Alunos aluno;
		if (StringUtils.isEmpty(matricula)) {
			aluno = alunosRepository.alunoRg(rg);
		} else {
			aluno = alunosRepository.alunoMatricula(matricula);
		}
		
		if (aluno == null) {
			throw new ExceptionAcademia("o aluno não foi encontrado");
		}
		
		Acessos ultimoAcesso = acessosRepository.ultimoAcesso(aluno.getMatricula());
		TipoAcesso tipoAcesso;
		
		if (ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPreenchidas()) {
			ultimoAcesso = new Acessos();
			ultimoAcesso.setAluno(aluno);
			tipoAcesso = ultimoAcesso.registrarAcesso();
			acessosRepository.save(ultimoAcesso);
		} else {
			tipoAcesso = ultimoAcesso.registrarAcesso();
		}
		
		return tipoAcesso;
	}

}
