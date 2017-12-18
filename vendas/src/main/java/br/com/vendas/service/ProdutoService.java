package br.com.vendas.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.vendas.entity.Produto;

@Stateless
public class ProdutoService {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Produto produto) {
		em.merge(produto);
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
}
