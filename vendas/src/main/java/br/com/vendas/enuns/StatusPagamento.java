package br.com.vendas.enuns;

public enum StatusPagamento {
	
	PAGO(1, "OK"),
	PENDENTE(2,"Pendente"),
	EM_ATRAZO(3,"Atrasado");

	private int codigo;
	private String descricao;

	private StatusPagamento(int codigo, String descricao) {
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
