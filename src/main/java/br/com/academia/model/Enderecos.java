package br.com.academia.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "RUA", nullable = false, length = 128)
	private String rua;
	
	@Column(name = "NUMERO", nullable = true, length = 6)
	private Integer numero;
	
	@Column(name = "COMPLEMENTo", nullable = true, length = 32)
	private String complemento;
	
	@Column(name = "CIDADE", nullable = false, length = 64)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "ESTADO_ID", nullable = false)
	private Estados estados = new Estados();
	
	@Column(name = "CEP", nullable = false, length = 8)
	private Integer cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, complemento, estados, numero, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enderecos other = (Enderecos) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estados, other.estados)
				&& Objects.equals(numero, other.numero) && Objects.equals(rua, other.rua);
	}

}

