package br.com.vendas.enuns;

public enum FormaPagamento {

	A_VISTA(0, "� Vista"),
	A_PRAZO(1,"� Prazo"),
	CARTAO_DEBITO(2,"Cart�o D�bito"),
	CARTAO_CREDITO(3,"Cart�o Cr�dito"),
	CARTAO_CREDITO_PARCELADO(4,"Parcelado no Cart�o"),;

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
