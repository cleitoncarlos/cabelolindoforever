package br.com.vendas.test;

import java.util.Arrays;
import java.util.List;

import br.com.vendas.entity.Venda;

public class VendasFactory {

	public static List<Venda> create() {
		Venda v = new Venda();
		Venda v2 = new Venda();
		return Arrays.asList(v, v2);

	}

}
