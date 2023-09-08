package br.com.academia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academia.model.Acessos;
import br.com.academia.model.Alunos;
import br.com.academia.model.Alunos.Situacao;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, String>{
	
	@Query(value = "SELECT a FROM Alunos a WHERE a.rg = ?1")
	Alunos alunoRg(Integer rg);
	
	@Query(value = "SELECT a FROM Alunos a WHERE a.matricula = ?1")
	Alunos alunoMatricula(String matricula);
	
	@Query(value = "SELECT MAX(a.matricula) "
			+ " from Alunos a "
			+ " WHERE a.matricula LIKE ?1%")
	String maxMatriculaAno(String ano);
	
	@Query(value = "SELECT a FROM Alunos a "
			+ " WHERE a.situacao = ?1 "
			+ " ORDER BY a.nome")
	List<Alunos> listSituacoesAlunos(Situacao situacao);
	
	@Query(value = "SELECT a FROM Acessos a "
			+ " WHERE a.alunos.matricula = ?1 AND "
			+ " a.entrada >= ?2 AND a.saida <= ?3 "
			+ " ORDER BY a.entrada")
	List<Acessos> listAcessosAlunos(String matricula, LocalDate entradaInicio, LocalDate saidaFim);
	
	@Query(value = "SELECT a FROM Alunos a "
			+ " WHERE a.rg like %?1% or a.matricula like %?1% or a.nome like %?1% or a.email like %?1% "
			+ " ORDER BY a.nome")
	List<Alunos> pesquisaAlunos(String pesquisa);
	
	@Query(value = "SELECT a FROM Alunos a "
			+ " ORDER BY a.nome")
	List<Alunos> listaAlunos();

}
