package impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemEntregueDao;
import dominio.Entrega;
import dominio.ItemEntregue;
import dominio.Produto;

public class ItemEntregueDaoImpl implements ItemEntregueDao {

	private EntityManager em;

	public ItemEntregueDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(ItemEntregue x) {
		if (x.getCodItemEntregue() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(ItemEntregue x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public ItemEntregue buscar(int cod) {
		return em.find(ItemEntregue.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemEntregue> buscarTodos() {
		String jpql = "SELECT x FROM ItemEntregue x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ItemEntregue buscaItensEntrega(Produto p, Entrega e) {
		String jpql = "SELECT item FROM ItemEntregue item WHERE produto  = :c1 and entrega = :c2";
		Query query = em.createQuery(jpql);
		query.setParameter("c1", p.getCodProduto());
		query.setParameter("c2", e.getCodEntrega());
		List<ItemEntregue> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0): null;
	}
	 
}