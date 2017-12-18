package br.com.vendas.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.vendas.entity.Cliente;
import br.com.vendas.enuns.Situacao;
import br.com.vendas.enuns.Tipo;

@Stateless
public class ClienteService {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Cliente cliente) {
		em.merge(cliente);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTudo() {
		try {
			Query query = em.createQuery("Select c from Cliente c");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Tipo> criaListaTipoCliente() {
		List<Tipo> listaTipos = new ArrayList<Tipo>();
		for (Tipo t : Tipo.values()) {
			listaTipos.add(t);
		}
		return listaTipos;
	}
	
	public List<Situacao> criaListaSituacaoCliente() {
		List<Situacao> situacoes = new ArrayList<Situacao>();
		for (Situacao t : Situacao.values()) {
			situacoes.add(t);
		}
		return situacoes;
	}
}
