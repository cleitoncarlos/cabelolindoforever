package br.com.vendas.enuns;

public enum FormaPagamento {

	A_VISTA(0, "À Vista"),
	A_PRAZO(1,"À Prazo"),
	CARTAO_DEBITO(2,"Cartão Débito"),
	CARTAO_CREDITO(3,"Cartão Crédito"),
	CARTAO_CREDITO_PARCELADO(4,"Parcelado no Cartão"),;

	private int codigo;
	private String descricao;

	private FormaPagamento(int codigo, String descricao) {
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
