package br.com.vendas.enuns;

public enum GrupoPai {
	
	
	ALIMENTOS			(0, "Alimentos"),
	BEBIDAS				(1,"Bebidas"),
	BELEZA				(2, "Beleza"),
	CAMA_MESA_BANHO		(3,"Cama, Mesa e Banho"),
	DIVERSOS			(4,"Diversos"),
	ELETRODOMESTICOS	(5,"Eletrodom�sticos"),
	ELETRONICO			(6,"Eletr�nicos"),
	INFORMATICA			(7,"Inform�tica"),
	MOVEIS_DECORACAO	(8,"M�veis e Decora��o"),
	TELEFONIA			(9,"Telefonia");
	
	

	private int codigo;
	private String descricao;

	private GrupoPai(int codigo, String descricao) {
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
