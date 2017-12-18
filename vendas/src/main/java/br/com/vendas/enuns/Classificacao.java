package br.com.vendas.enuns;

public enum Classificacao {

	A(0,"A"),
	B(1,"B"),
	C(2,"C");
	
	private int codigo;
	private String descricao;

	private Classificacao(int codigo, String descricao) {
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
