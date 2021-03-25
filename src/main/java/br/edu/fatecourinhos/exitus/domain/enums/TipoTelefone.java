package br.edu.fatecourinhos.exitus.domain.enums;

public enum TipoTelefone {

	FIXO(1, "Fixo"),
	CELULAR(2, "Celular");
	
	private int cod;
	private String descricao;
	
	private TipoTelefone(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}
	
}
