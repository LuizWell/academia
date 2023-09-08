package br.com.academia.enuns;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public enum TipoAcesso {
	ENTRADA("Entrada"), 
	SAIDA("Saída");
	
	private String descricao;

	TipoAcesso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    @Override
	public String toString() {
		return this.descricao;
	}
}
