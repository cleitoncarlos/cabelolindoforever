package br.com.vendas.enuns;

public enum Vendedor {
	
	CLEITON_CARLOS(0, "Cleiton Carlos"),
	VANUZA_PRADO(1,"Vanuza Prado");

	private int codigo;
	private String descricao;

	private Vendedor(int codigo, String descricao) {
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
