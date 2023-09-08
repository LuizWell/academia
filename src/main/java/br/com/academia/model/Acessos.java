package br.com.academia.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.academia.enuns.TipoAcesso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTRADAS_SAIDAS")
public class Acessos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ALUNO_ID", nullable = false)
	private Alunos alunos;

	@Column(name = "ENTRADA", nullable = false)
	private LocalDateTime entrada;

	@Column(name = "SAIDA", nullable = true)
	private LocalDateTime saida;

	public boolean isEntradaSaidaPreenchidas() {
		if (entrada != null && saida != null) {
			return true;
		}
		return false;
	}

	public TipoAcesso registrarAcesso() {
		LocalDateTime now = LocalDateTime.now();
		TipoAcesso tipoAcesso;

		if (entrada == null) {
			entrada = now;
			tipoAcesso = TipoAcesso.ENTRADA;
		} else if (saida == null) {
			saida = now;
			tipoAcesso = TipoAcesso.SAIDA;
		} else {
			tipoAcesso = null;

		}
		return tipoAcesso;

	}
	
	public String calcularDuracao() {
		if (entrada == null || saida == null) {
			return null;
		}
		
		Duration d = Duration.between(entrada, saida);
		return String.format("%02d:%02d", d.toHoursPart(), d.toMinutesPart());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alunos getAluno() {
		return alunos;
	}

	public void setAluno(Alunos alunos) {
		this.alunos = alunos;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acessos other = (Acessos) obj;
		return Objects.equals(id, other.id);
	}

}
