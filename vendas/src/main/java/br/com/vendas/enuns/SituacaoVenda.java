package br.com.vendas.enuns;

public enum SituacaoVenda {

	EM_ABERTO(0, "encomenda"),
	EM_ANDAMENTO(1,"em andamento"),
	CONCRETIZADA(2,"concretizada"),
	CANCELADA(3,"cancelada");

	private int codigo;
	private String descricao;

	private SituacaoVenda(int codigo, String descricao) {
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
