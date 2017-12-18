package br.com.vendas.enuns;

public enum StatusProduto {
	
	ESTOQUE_CONFORTAVEL(0, "Estoque Confortável"),
	ESTOQUE_MODERADO(1,"Estoque Moderado"),
	ESTOQUE_BAIXO(2,"Estoque Baixo"),
	EM_FALTA(3,"Em Falta");

	private int codigo;
	private String descricao;

	private StatusProduto(int codigo, String descricao) {
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
