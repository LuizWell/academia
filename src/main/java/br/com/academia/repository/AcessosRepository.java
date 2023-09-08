package br.com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academia.model.Acessos;

@Repository
public interface AcessosRepository extends JpaRepository<Acessos, Integer>{
	
	@Query(value = "SELECT a FROM Acessos a WHERE a.alunos.matricula = ?1 "
			+ " ORDER BY a.id DESC ")
	Acessos ultimoAcesso(String matricula);

}
