package br.com.vendas.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.morenalinks.msg.util.MenssagemUtil;
import br.com.vendas.entity.Cliente;
import br.com.vendas.entity.CurvaABC;
import br.com.vendas.entity.ItensVenda;
import br.com.vendas.entity.Produto;
import br.com.vendas.entity.Venda;
import br.com.vendas.enuns.Classificacao;
import br.com.vendas.enuns.FormaPagamento;
import br.com.vendas.enuns.SituacaoVenda;
import br.com.vendas.enuns.StatusPagamento;
import br.com.vendas.service.CurvaABCService;
import br.com.vendas.service.ProdutoService;
import br.com.vendas.service.VendaService;

@Named
@SessionScoped
public class VendaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1793995911926386510L;

	@Inject
	private ProdutoService produtoService;

	@Inject
	private CurvaABCService abcService;

	@Inject
	private VendaService vendaService;
	private Produto produto;
	private List<Produto> produtos;
	private List<Produto> produtoEstoque;
	private List<Cliente> clientes;
	private Set<ItensVenda> itens;
	private List<FormaPagamento> formaPagamento;
	private List<SituacaoVenda> situacaoVenda;
	private List<Venda> vendas;
	private ItensVenda itensVenda;
	private List<ItensVenda> listaItens;
	private List<ItensVenda> itensCurvaABC;
	private List<CurvaABC> listaCurvaABC;

	private Venda venda;
	private BigDecimal totalVendas;
	private BigDecimal porcTotal;
	private CurvaABC curvaABC;
	private boolean ativa = false;

	private BigDecimal subTotal;

	private int quantidade;

	private BigDecimal valor;
	private BigDecimal totalDesconto;
	private BigDecimal valorTotalSemDesconto;

	@PostConstruct
	private void init() {

		this.venda = new Venda();
		venda.setDataCadastro(new Date());

		this.produto = new Produto();
		this.itensVenda = new ItensVenda();
		this.itensVenda.setDesconto(new BigDecimal(0));
		subTotal = new BigDecimal(0);

		quantidade = 0;

		valor = new BigDecimal(0);
		setTotalDesconto(new BigDecimal(0));
		setValorTotalSemDesconto(new BigDecimal(0));

		produtos = new ArrayList<Produto>();
		produtos = produtoService.listarTudo();

		this.produtoEstoque = new ArrayList<Produto>();

		vendas = new ArrayList<Venda>();
		vendas = vendaService.listarVendas();
		verificaStatusPagamento();

		listaCurvaABC = new ArrayList<>();
		// listaCurvaABC = abcService.listarCurvaABC();

		clientes = new ArrayList<Cliente>();
		clientes = vendaService.listarClientes();

		this.itens = new HashSet<ItensVenda>();

		this.listaItens = new ArrayList<>();
		listaItens = vendaService.listarItensVenda();

		setFormaPagamento(new ArrayList<FormaPagamento>());
		setFormaPagamento(vendaService.criaListaFormaPagamento());

		setSituacaoVenda(new ArrayList<SituacaoVenda>());
		setSituacaoVenda(vendaService.criaListaSituacaoVenda());

		itensVenda.setDesconto(new BigDecimal(0));

	}

	public void calculaCurvaABC() {
		listaCurvaABC = new ArrayList<>();
		ativa = true;
		this.itensCurvaABC = new ArrayList<ItensVenda>();

		List<CurvaABC> lisaABC = new ArrayList<CurvaABC>();

		BigDecimal total = new BigDecimal(0);
		BigDecimal subtotal = new BigDecimal(0);
		BigDecimal porc = new BigDecimal(0);
		totalVendas = new BigDecimal(0);
		BigDecimal porcent = new BigDecimal(0);
		BigDecimal porcentClass = new BigDecimal(0);
		boolean verifica = false;
		int cont = 0;
		List<CurvaABC> listaABCaux = new ArrayList<CurvaABC>();

		ItensVenda itemaux = new ItensVenda();

		for (Produto produto : produtos) {

			int qtd = 0;
			itemaux = new ItensVenda();
			this.curvaABC = new CurvaABC();
			CurvaABC busca = new CurvaABC();

			for (ItensVenda item : listaItens) {

				// busca = abcService.buscaDadosPorIdProduto(item.getProduto());

				// if (busca == null) {

				if (item.getProduto().getCodigo() == produto.getCodigo()) {

					qtd = qtd + item.getQuantidade();
				}
				/* } */ else if (busca != null && item.getProduto().getCodigo() == produto.getCodigo()) {
					qtd = busca.getQuantidadeVendida() + item.getQuantidade();
				}
			}
			if (qtd != 0 /* && busca == null */) {

				this.curvaABC.setQuantidadeVendida(qtd);
				subtotal = produto.getValorVenda().multiply(BigDecimal.valueOf(qtd));
				this.curvaABC.setValorTotalPorProduto(subtotal);
				this.curvaABC.setProduto(produto);
				total = total.add(subtotal);

				lisaABC.add(curvaABC);
			} /*
				 * else if (qtd != 0 && busca != null) {
				 * 
				 * busca.setQuantidadeVendida(qtd); subtotal =
				 * produto.getValorVenda().multiply(BigDecimal.valueOf(qtd));
				 * busca.setValorTotalPorProduto(subtotal); total = total.add(subtotal);
				 * 
				 * lisaABC.add(busca); }
				 */
		}

		/*
		 * // porc = (subtotal.divide(totalVendas, MathContext.DECIMAL128)).multiply(new
		 * BigDecimal(100)); porc = (subtotal.divide(totalVendas, 2,
		 * RoundingMode.HALF_EVEN)).multiply(new BigDecimal(100));
		 */

		if (!lisaABC.isEmpty()) {

			this.totalVendas = total;

			for (CurvaABC c : lisaABC) {
				System.out.println("Curva ABC: " + c);
				c.setPorcentagem(porc = (c.getValorTotalPorProduto().divide(totalVendas, 4, RoundingMode.HALF_EVEN))
						.multiply(new BigDecimal(100)));

				listaCurvaABC.add(c);
			}

			/*
			 * try { System.out.println("Total Vendas 1: " + totalVendas);
			 * abcService.salvar(listaCurvaABC); init();
			 * System.out.println("Total Vendas 2: " + totalVendas); } catch (Exception e) {
			 * e.printStackTrace(); }
			 */
		}

		/* else { */
		for (CurvaABC c : listaCurvaABC) {

			porcent = porcent.add(c.getPorcentagem());
			porcentClass = porcentClass.add(c.getPorcentagem());

			// this.totalVendas =
			// totalVendas.add(c.getProduto().getValorVenda().multiply(BigDecimal.valueOf(c.getQuantidadeVendida())));

			if (porcent.doubleValue() == 100 && cont == 0) {
				porcentClass = porcentClass.add(c.getPorcentagem());
				c.setClassificacao(Classificacao.A);
			} else if (verifica == false && porcentClass.doubleValue() <= 80) {
				porcentClass = porcentClass.add(c.getPorcentagem());
				c.setClassificacao(Classificacao.A);
			} else if (verifica == false && porcentClass.doubleValue() > 80) {
				c.setClassificacao(Classificacao.B);
				porcentClass = new BigDecimal(0);
				verifica = true;
			} else if (verifica && porcentClass.doubleValue() <= 15) {
				porcentClass = porcentClass.add(c.getPorcentagem());
				c.setClassificacao(Classificacao.B);
			} else if (verifica && porcentClass.doubleValue() >= 15) {
				c.setClassificacao(Classificacao.C);
			}

			c.setPorcAcumulada(porcent);
			this.porcTotal = porcent;
			cont++;
		}
		/* } */

	}

	public void salvar() {

		try {

			if (venda.getSituacaoVenda().equals(SituacaoVenda.EM_ANDAMENTO)
					|| venda.getSituacaoVenda().equals(SituacaoVenda.EM_ABERTO)) {
				venda.setStausPagamento(StatusPagamento.PENDENTE);

			} else if (venda.getSituacaoVenda().equals(SituacaoVenda.CONCRETIZADA)
					&& venda.getFormaPagamento().equals(FormaPagamento.A_PRAZO)) {

				venda.setStausPagamento(StatusPagamento.PENDENTE);

			} else if (venda.getSituacaoVenda().equals(SituacaoVenda.CANCELADA)) {
				venda.setStausPagamento(StatusPagamento.CANCELADO);

				for (Produto produto : produtos) {

					for (ItensVenda item : venda.getItens()) {

						if (produto.getCodigo() == item.getProduto().getCodigo()) {
							int estoque = 0;
							estoque = item.getQuantidade();
							produto.setEstoqueAtual(produto.getEstoqueAtual() + estoque);
						}
					}
				}

			} else
				venda.setStausPagamento(StatusPagamento.PAGO);

			vendaService.salvar(venda);
			produtoService.alterarEstoque(produtos);
			MenssagemUtil.mensagemInfo("Venda Cadastrado!!");
			init();

		} catch (Exception e) {
			MenssagemUtil.mensagemErro("Erro ao Salvar Produto!");
			e.printStackTrace();
		}
	}

	public void verificaStatusPagamento() {
		for (Venda venda : vendas) {
			if (venda.getFormaPagamento().equals(FormaPagamento.A_PRAZO)
					&& !venda.getSituacaoVenda().equals(SituacaoVenda.CANCELADA)
					&& venda.getDataPrevisaoPagamento().before(new Date())) {
				venda.setStausPagamento(StatusPagamento.EM_ATRAZO);
			}
		}
	}

	public void editarVenda(Venda v) {

		for (Venda venda : vendas) {
			if (venda.getCodigo() == v.getCodigo()) {
				System.out.println("Venda: " + venda.getCodigo() + "Itens da Venda: " + venda.getItens());
				itens = venda.getItens();
			}
		}
	}

	public void remover(Venda v) {
		try {
			vendaService.excluir(v);
			init();
			MenssagemUtil.mensagemInfo("Excluido com Sucesso!!");
		} catch (Exception e) {
			MenssagemUtil.mensagemErro(e.getMessage());
		}
	}

	public void adionaIntens() {

		this.itens.add(itensVenda);

		this.venda.adionaIntensVenda(itens);

		this.quantidade = quantidade + itensVenda.getQuantidade();
		this.valor = valor.add(itensVenda.getValorTotal());
		this.totalDesconto = totalDesconto.add(itensVenda.getDesconto());
		this.valorTotalSemDesconto = valorTotalSemDesconto.add(itensVenda.getSubTotal());

		venda.setQuantidadeTotal((quantidade));
		venda.setValorTotal(valor);

		for (Produto produto : produtos) {
			if (produto.getCodigo() == itensVenda.getProduto().getCodigo()) {
				int estoque = 0;
				estoque = itensVenda.getQuantidade();
				produto.setEstoqueAtual(produto.getEstoqueAtual() - estoque);
				this.produtoEstoque.add(produto);
			}
		}

		itensVenda = new ItensVenda();
		this.itensVenda.setDesconto(new BigDecimal(0));

		MenssagemUtil.mensagemInfo("Produto inserido na Lista!!");

	}

	public void removeItens(ItensVenda item) {
		itens.remove(item);

		this.quantidade = quantidade - item.getQuantidade();
		this.valor = valor.subtract(item.getValorTotal());
		venda.setQuantidadeTotal((quantidade));
		venda.setValorTotal(valor);

		itensVenda = new ItensVenda();
		MenssagemUtil.mensagemInfo("Produto removido da Lista!!");
	}

	public void selecionaItem() {
		ItensVenda item = itensVenda;
		System.out.println("Produto: " + itensVenda.getProduto().getNomeProduto());
	}

	public void calculaValor() {

		for (Produto produto : produtos) {
			if (produto.getCodigo() == itensVenda.getProduto().getCodigo()) {

				itensVenda
						.setSubTotal(produto.getValorVenda().multiply(BigDecimal.valueOf(itensVenda.getQuantidade())));

				if (itensVenda.getDesconto() == null) {
					this.itensVenda.setValorTotal(itensVenda.getSubTotal());
				} else
					this.itensVenda.setValorTotal(
							produto.getValorVenda().multiply(BigDecimal.valueOf(itensVenda.getQuantidade()))
									.subtract(itensVenda.getDesconto()));
			}
		}
		// itensVenda = new ItensVenda();
	}

	public List<Produto> completeProduto(String query) {
		// List<Produto> allProdutos = produtoService.listarTudo();
		List<Produto> filteredProdutos = new ArrayList<Produto>();

		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			if (produto.getNomeProduto().toLowerCase().startsWith(query)) {
				filteredProdutos.add(produto);
			}
		}
		if (filteredProdutos.isEmpty()) {
			MenssagemUtil.mensagemInfo("Produto nao encontrado!");
			return filteredProdutos;
		} else
			return filteredProdutos;
	}

	public List<Cliente> completeCliente(String query) {
		List<Cliente> allClientes = clientes;
		List<Cliente> filteredClientes = new ArrayList<Cliente>();

		for (int i = 0; i < allClientes.size(); i++) {
			Cliente cliente = allClientes.get(i);
			if (cliente.getNome().toLowerCase().startsWith(query)) {
				filteredClientes.add(cliente);
			}
		}

		return filteredClientes;
	}

	public void verificaFormaPagamento() {

		if (venda.getFormaPagamento().getDescricao().equals("À Vista")) {

			venda.setDataPrevisaoPagamento(venda.getDataVenda());
			venda.setDataPagamento(venda.getDataVenda());
		} else if (venda.getFormaPagamento().getDescricao().equals("À Prazo")) {
			return;
		} else
			return;

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
		init();
	}

	public void limpaFormItens() {
		this.itensVenda = new ItensVenda();
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

	public Set<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItensVenda> itens) {
		this.itens = itens;
	}

	public ItensVenda getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(ItensVenda itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public List<FormaPagamento> getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(List<FormaPagamento> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<SituacaoVenda> getSituacaoVenda() {
		return situacaoVenda;
	}

	public void setSituacaoVenda(List<SituacaoVenda> situacaoVenda) {
		this.situacaoVenda = situacaoVenda;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public BigDecimal getTotalDesconto() {
		return totalDesconto;
	}

	public void setTotalDesconto(BigDecimal totalDesconto) {
		this.totalDesconto = totalDesconto;
	}

	public BigDecimal getValorTotalSemDesconto() {
		return valorTotalSemDesconto;
	}

	public void setValorTotalSemDesconto(BigDecimal valorTotalSemDesconto) {
		this.valorTotalSemDesconto = valorTotalSemDesconto;
	}

	public List<ItensVenda> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItensVenda> listaIntens) {
		this.listaItens = listaIntens;
	}

	public List<ItensVenda> getItensCurvaABC() {
		return itensCurvaABC;
	}

	public void setItensCurvaABC(List<ItensVenda> itensCurvaABC) {
		this.itensCurvaABC = itensCurvaABC;
	}

	public BigDecimal getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVednas(BigDecimal totalVedas) {
		this.totalVendas = totalVedas;
	}

	public List<CurvaABC> getListaCurvaABC() {
		return listaCurvaABC;
	}

	public void setListaCurvaABC(List<CurvaABC> listaCurvaABC) {
		this.listaCurvaABC = listaCurvaABC;
	}

	public BigDecimal getPorcTotal() {
		return porcTotal;
	}

	public void setPorcTotal(BigDecimal porcTotal) {
		this.porcTotal = porcTotal;
	}

	public CurvaABC getCurvaABC() {
		return curvaABC;
	}

	public void setCurvaABC(CurvaABC curvaABC) {
		this.curvaABC = curvaABC;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public List<Produto> getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(List<Produto> produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

}
