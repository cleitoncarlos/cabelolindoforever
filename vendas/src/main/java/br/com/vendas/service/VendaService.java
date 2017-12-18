package br.com.vendas.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.vendas.entity.Cliente;
import br.com.vendas.entity.ItensVenda;
import br.com.vendas.entity.Produto;
import br.com.vendas.entity.Venda;
import br.com.vendas.enuns.FormaPagamento;
import br.com.vendas.enuns.SituacaoVenda;

@Stateless
public class VendaService {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Venda venda) {
		em.merge(venda);
	}

	public void excluir(Venda v) {
		try {
			em.remove(em.find(Venda.class, v.getCodigo()));
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Object> buscaDadosCurvaABC() {

		/*
		 * String jpql = "Select sum(iv.quantidade), p.nomeProduto from ItensVenda iv "
		 * + "join Produto p on " + "p.codigo = iv.produto.codigo"; Query consulta =
		 * em.createQuery(jpql); return consulta.getResultList();
		 */

		try {
			Query query = em.createQuery("Select sum(iv.quantidade), iv.produto.nomeProduto,iv.produto.valorVenda,sum(iv.quantidade*iv.produto.valorVenda)"
					+ " from ItensVenda iv "
					+ "group by iv.produto.nomeProduto,iv.produto.valorVenda");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listarTudo() {
		try {
			Query query = em.createQuery("Select p from Produto p");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() {
		try {
			Query query = em.createQuery("Select c from Cliente c");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ItensVenda> listarItensVenda() {
		try {
			Query query = em.createQuery("Select i from ItensVenda i");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Venda> listarVendas() {
		try {
			Query query = em.createQuery("Select v from Venda v order by v.codigo");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<FormaPagamento> criaListaFormaPagamento() {
		List<FormaPagamento> formPagamento = new ArrayList<FormaPagamento>();
		for (FormaPagamento f : FormaPagamento.values()) {
			formPagamento.add(f);
		}
		return formPagamento;
	}

	public List<SituacaoVenda> criaListaSituacaoVenda() {
		List<SituacaoVenda> situacaoVenda = new ArrayList<SituacaoVenda>();
		for (SituacaoVenda s : SituacaoVenda.values()) {
			situacaoVenda.add(s);
		}
		return situacaoVenda;
	}
}
