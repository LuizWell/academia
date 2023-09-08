package br.com.academia.service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academia.model.Acessos;
import br.com.academia.model.Alunos;
import br.com.academia.model.Alunos.Situacao;
import br.com.academia.repository.AlunosRepository;
import br.com.academia.util.StringUtils;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public void createOrUpdate(Alunos aluno) {
		if (StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		} else {
			update(aluno);
		}
	}
	
	private void create(Alunos aluno) {

		String maxMatricula = alunosRepository.maxMatriculaAno(Year.now().toString());
		aluno.gerarMatricula(maxMatricula);
		alunosRepository.save(aluno);
	}

	public void delete(String matricula) {
		alunosRepository.deleteById(matricula);
	}

	private void update(Alunos aluno) {
		alunosRepository.save(aluno);
	}

	public Alunos findByMatricula(String Matricula) {
		return alunosRepository.alunoMatricula(Matricula);
	}
	
	public List<Alunos> listaAlunos() {

		return alunosRepository.listaAlunos();
	}

	public List<Alunos> pesquisaAlunos(String pesquisa) {

		return alunosRepository.pesquisaAlunos(pesquisa);
	}

	public List<Alunos> listSituacoesAlunos(Situacao situacao) {
		return alunosRepository.listSituacoesAlunos(situacao);
	}
	
	public List<Acessos> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
		
		return alunosRepository.listAcessosAlunos(matricula, dataInicial, dataFinal);
	}

}
