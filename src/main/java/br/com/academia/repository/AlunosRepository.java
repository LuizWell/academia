package br.com.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academia.model.Acessos;
import br.com.academia.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, String>{
	
	@Query(value = "SELECT a FROM Alunos a WHERE a.rg = ?1")
	Alunos alunoRg(String rg);
	
	@Query(value = "SELECT MAX(a.matricula) "
			+ " from Alunos a "
			+ " WHERE a.matricula LIKE ?1%")
	List<Alunos> listaAlunosAno(String ano);
	
	@Query(value = "SELECT a FROM Alunos a "
			+ " WHERE a.situacao = ?1 "
			+ " ORDER BY a.nome")
	List<Alunos> listSituacoesAlunos(String situacao);
	
	@Query(value = "SELECT a FROM Acessos a "
			+ " WHERE a.alunos.matricula = ?1 AND "
			+ " a.entrada >= ?2 AND a.saida <= ?3 "
			+ " ORDER BY a.entrada")
	List<Acessos> listAcessosAlunos(String matricula, String EntradaInicio, String saidaFim);

}
