package impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ClienteDao;
import dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private EntityManager em;

	public ClienteDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Cliente x) {
		if (x.getCodCliente() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Cliente x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Cliente buscar(int cod) {
		return em.find(Cliente.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT x FROM Cliente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Cliente existeCliente(String cpf) {
		String jpql = "SELECT x FROM Cliente x WHERE cpf LIKE ':cpf'";
		Query query = em.createQuery(jpql);
		query.setParameter("cpf", cpf);
		List<Cliente> aux = query.getResultList();
		return aux.size()>0 ? aux.get(0):null;
	}
}