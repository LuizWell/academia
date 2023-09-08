package br.com.academia.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Telefones implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CELULAR_DDD", nullable = false, length = 2)
	private Integer dddCelular;
	
	@Column(name = "CELULAR_NUMERO", nullable = false, length = 9)
	private Integer numeroCelular;
	
	@Column(name = "FIXO_DDD", nullable = true, length = 2)
	private Integer dddFixo;
	
	@Column(name = "FIXO_NUMERO", nullable = true, length = 9)
	private Integer numeroFixo;

	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}

	public Integer getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Integer getDddFixo() {
		return dddFixo;
	}

	public void setDddFixo(Integer dddFixo) {
		this.dddFixo = dddFixo;
	}

	public Integer getNumeroFixo() {
		return numeroFixo;
	}

	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dddCelular, dddFixo, numeroCelular, numeroFixo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefones other = (Telefones) obj;
		return Objects.equals(dddCelular, other.dddCelular) && Objects.equals(dddFixo, other.dddFixo)
				&& Objects.equals(numeroCelular, other.numeroCelular) && Objects.equals(numeroFixo, other.numeroFixo);
	}

}

