package br.com.vendas.enuns;

public enum Tipo {

	PESSOA_FISICA(0, "Pessoa F�sica"),
	PESSOA_JURIDICA(1,"Pessoa Jur�dica");

	private int codigo;
	private String descricao;

	private Tipo(int codigo, String descricao) {
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
