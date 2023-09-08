package br.com.academia.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academia.ExceptionAcademia;
import br.com.academia.model.Acessos;
import br.com.academia.model.Alunos;
import br.com.academia.model.Alunos.Situacao;
import br.com.academia.service.AlunosService;

@Controller
@RestController
@RequestMapping(value = "/alunos")
public class AlunosController {
	
	@Autowired
	private AlunosService alunosService;
	
	@PostMapping(value = "/salvar") 
	public ResponseEntity<?> salvar(@RequestBody @Valid Alunos aluno, BindingResult result) {
	    	
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		
		try {
			alunosService.createOrUpdate(aluno); 
			}catch (ExceptionAcademia e){
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		return new ResponseEntity<Alunos>(aluno, HttpStatus.CREATED);

	 }
	
	 @GetMapping(value = "/lista")
	 public List<Alunos> lista(){
	    	
		 return alunosService.listaAlunos();
	    	
	 }
	 
	 @GetMapping(value = "/pesquisa")
	 public List<Alunos> pesquisa(@RequestParam(name = "pesquisa") String pesquisa){
	    	
		 return alunosService.pesquisaAlunos(pesquisa);
	    	
	 }
	 
	 @DeleteMapping(value = "/{matricula}")
	 public ResponseEntity<?> delete(@PathVariable String matricula){
	    	
		 alunosService.delete(matricula);
		 
		 return new ResponseEntity<String>("Aluno deletado com sucesso", HttpStatus.OK);
	    	
	 }
	 
	 @GetMapping(value = "/listaAcessos")
	 public ResponseEntity<?> listaAcessos(@RequestParam(name = "matricula") String matricula,
			 						@RequestParam(name = "dataIni") LocalDate dataIni, 
			 						@RequestParam(name = "dataFim") LocalDate dataFim) {
		List<Acessos> acessos;
		
		try {
		acessos = alunosService.listAcessosAlunos(matricula, dataIni, dataFim);
		} catch (ExceptionAcademia e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return new ResponseEntity<List<Acessos>>(acessos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listaAcessosSituacao")
	public ResponseEntity<?> listaAcessosSituacao(@RequestBody Situacao situacao) {
		List<Alunos> acessos;
		
		try {
		acessos = alunosService.listSituacoesAlunos(situacao);
		} catch (ExceptionAcademia e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return new ResponseEntity<List<Alunos>>(acessos, HttpStatus.OK);
	}
	

}
