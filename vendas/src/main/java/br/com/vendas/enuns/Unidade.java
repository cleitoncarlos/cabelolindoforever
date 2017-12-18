package br.com.vendas.enuns;

public enum Unidade {
	
	UN(1, "Unidade"),
	KG(2,"Quilograma"),
	CX(3,"Caixa"),
	KIT(4,"Kit");

	private int codigo;
	private String descricao;

	private Unidade(int codigo, String descricao) {
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
