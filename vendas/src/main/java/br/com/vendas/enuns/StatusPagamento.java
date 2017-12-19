package br.com.vendas.enuns;

public enum StatusPagamento {
	
	PAGO(0, "efetivado"),
	PENDENTE(1,"pendente"),
	EM_ATRAZO(2,"atrasado"),
	CANCELADO(3,"cancelado");

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
