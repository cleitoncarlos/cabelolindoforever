package br.com.vendas.enuns;

public enum Situacao {
	
	ATIVO(0, "Ativo"),
	INATIVO(1,"Inativo");

	private int codigo;
	private String descricao;

	private Situacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
