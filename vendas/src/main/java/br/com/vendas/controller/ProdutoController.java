package br.com.vendas.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.morenalinks.msg.util.MenssagemUtil;
import br.com.vendas.entity.Grupo;
import br.com.vendas.entity.Produto;
import br.com.vendas.service.ProdutoService;

@Named
@SessionScoped
public class ProdutoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1793995911926386510L;

	@Inject
	private ProdutoService produtoService;
	private Produto produto;
	private List<Produto> produtos;
	private List<Grupo> grupoProduto;

	@PostConstruct
	private void init() {

		System.out.println("Init....");
		this.produto = new Produto();

		produtos = new ArrayList<Produto>();
		produtos = produtoService.listarTudo();
		// this.setProdutos(new ArrayList<Produto>());
	}

	public void salvar() {

		try {
			System.out.println("Salvar Aviso....");
			produto.setDataCadastro(Calendar.getInstance());
			produtoService.salvar(produto);
			MenssagemUtil.mensagemInfo("Produto Cadastrado!!");
			limpaForm();

		} catch (Exception e) {
			MenssagemUtil.mensagemErro("Erro ao Salvar Produto!");
			e.printStackTrace();
		}
	}

	public void alterarEstoque(List<Produto> produtos) {

		produtoService.alterarEstoque(produtos);

	}

	public void calculaPreco() {

		System.out.println("Produto-ValorCompra: " + produto);

		produto.setValorVenda(
				((produto.getValorCompraAtual().multiply(produto.getPorcVenda()).divide(new BigDecimal(100)))
						.add(produto.getValorCompraAtual())));

		produto.setLucroEmReais(produto.getValorVenda().subtract(produto.getValorCompraAtual()));

		System.out.println("Produto-ValorVenda: " + produto.getValorCompraAtual());

		System.out.println("Produto-Lucro em Reais: " + produto.getLucroEmReais());
	}

	public void limpaForm() {
		this.produto = new Produto();
	}

	public void alteraEstoqueInicial() {
		System.out.println("Produto: " + produto.getEstoqueInicial());
		this.produto.setEstoqueInicial(produto.getEstoqueAtual());
	}

	public void alteraValorCompaInicial() {
		System.out.println("Produto: " + produto.getEstoqueInicial());
		this.produto.setValorCompraInicial(produto.getValorCompraAtual());
	}

	/* =============GETES e SETES============== */

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
