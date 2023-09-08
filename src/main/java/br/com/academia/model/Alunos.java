package br.com.academia.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import br.com.academia.util.StringUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ALUNOS")
public class Alunos implements Serializable{

	private static final long serialVersionUID = 1L;

	public enum Sexo {
		Masculino, Feminino;
	}

	public enum Situacao {
		Ativo, Inativo, Pendente;
	}

	@Id
	@Column(name = "ID", nullable = false, length = 8)
	private String matricula;
	
	@Column(name = "NOME", nullable = false, length = 64)
	private String nome;
	
	@Enumerated
	@Column(name = "SEXO", nullable = false, length = 1)
	private Sexo sexo;
	
	@Column(name = "RG", nullable = false, length = 10)
	private Integer rg;
	
	@Column(name = "NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;
	
	@Enumerated
	@Column(name = "SITUACAO", nullable = false, length = 1)
	private Situacao situacao;
	
	@Column(name = "EMAIL", nullable = false, length = 64)
	private String email;
	
	@Embedded
	private Enderecos enderecos = new Enderecos();
	
	@Embedded
	private Telefones telefones = new Telefones();
	
	public void gerarMatricula (String maxMatricula) {
		Year year = Year.now();
		
		if (maxMatricula == null) {
			maxMatricula = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequencial = Integer.parseInt(maxMatricula.substring(4));
		sequencial++;
		
		this.matricula = year + StringUtils.leftZeroes(sequencial, 4);
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Enderecos getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Enderecos enderecos) {
		this.enderecos = enderecos;
	}

	public Telefones getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefones telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alunos other = (Alunos) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}	

}

