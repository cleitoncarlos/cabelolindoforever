package br.com.vendas.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.vendas.entity.CurvaABC;
import br.com.vendas.entity.Produto;

@Stateless
public class CurvaABCService {

	@PersistenceContext
	private EntityManager em;

	public void salvar(List<CurvaABC> listabc) throws Exception {

		/*
		 * try { if (abc.getCodigo() == null) { CurvaABC curvaABC =
		 * buscaPorNome(abc.getProduto().getNomeProduto()); if (curvaABC != null) {
		 * System.out.println(curvaABC.getCodigo()); throw new
		 * Exception("Tabela Atualizada!!!", null); } }
		 */
		for (CurvaABC curvaABC : listabc) {
			System.out.println("\nABC-Produto: " + curvaABC.getProduto().getNomeProduto());
			em.merge(curvaABC);
		}
		

		/*
		 * } catch (Exception e) { throw new Exception(e); }
		 */
	}

	@SuppressWarnings("unchecked")
	public List<CurvaABC> listarCurvaABC() {
		try {
			Query query = em.createQuery("Select c from CurvaABC c order by c.porcentagem desc");
			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CurvaABC buscaDadosPorIdProduto(Produto produto) {
		if (produto != null) {
			try {
				String sql = "Select c from CurvaABC c where c.produto.codigo = :codigoProduto ";
				Query consulta = em.createQuery(sql);
				consulta.setParameter("codigoProduto", produto.getCodigo());
				return (CurvaABC) consulta.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		} else
			return null;
	}

	public CurvaABC buscaPorNome(String nome) throws Exception {

		try {
			String jpql = "Select c from CurvaABC c where lower(c.produto.nomeProduto)=lower(:nomeParam)";

			Query consulta = em.createQuery(jpql);

			consulta.setParameter("nomeParam", nome);
			consulta.setMaxResults(1);
			return (CurvaABC) consulta.getSingleResult();
		} catch (NoResultException e) {
			// engolir a exception
			return null;
		} catch (Exception causa) {
			throw new Exception("Erro ao Buscar nome!! " + causa);

		}
	}

}
