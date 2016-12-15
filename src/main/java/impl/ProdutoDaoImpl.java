package impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ProdutoDao;
import dominio.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

	private EntityManager em;

	public ProdutoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Produto x) {
		if (x.getCodProduto() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Produto x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Produto buscar(int cod) {
		return em.find(Produto.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarTodos() {
		String jpql = "SELECT x FROM Produto x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	public List<Produto> buscarTodosOrdenadoNome() {
		String jpql = "SELECT x FROM Produto x ORDER BY x.nome ASC";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscaNomePreco(String nome, BigDecimal valorMin, BigDecimal valorMax){
		String jpql = "SELECT x FROM Produto x WHERE x.nome LIKE :p1 AND x.preco >= :p2 AND x.preco <= :p3 ORDER BY x.nome";
			Query query = em.createQuery(jpql);
			query.setParameter("p1", "%"+nome+"%");
			query.setParameter("p2", valorMin);
			query.setParameter("p3", valorMax);
		return query.getResultList();
		
	}

	@Override
	public Produto buscaNomeExatoDiferente(Integer codProduto, String nome) {
		String jpql = "SELECT x FROM Produto x WHERE x.codProduto <> :p0 AND x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codProduto);
		query.setParameter("p1", nome);
		List<Produto> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	@Override
	public Produto buscaNomeExato(String nome) {
		String jpql = "SELECT x FROM Produto x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Produto> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@Override
	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT x FROM Produto x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1","%"+nome+"%");
		List<Produto> aux = query.getResultList();
		return aux;
	}
}
