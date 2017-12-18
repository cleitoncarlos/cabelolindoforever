package br.com.vendas.entity;

public enum TipoMovimentacao {
	
	ENTRADA(0, "Entrada"),
	SAIDA(1,"Saida");
	
	private int codigo;
	private String descricao;

	private TipoMovimentacao(int codigo, String descricao) {
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
