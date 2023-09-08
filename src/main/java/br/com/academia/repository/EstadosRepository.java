package br.com.academia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academia.model.Estados;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, String>{
	
	@Query(value = "SELECT e FROM Estados e ORDER BY e.nome")
	List<Estados> listaEstados();

}
