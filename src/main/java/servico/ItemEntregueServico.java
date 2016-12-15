package servico;

import java.util.List;

import dao.DaoFactory;
import dao.EntregaDao;
import dao.ItemEntregueDao;
import dao.ProdutoDao;
import dao.Transaction;
import dominio.Entrega;
import dominio.ItemEntregue;
import dominio.Produto;

public class ItemEntregueServico {

	private ItemEntregueDao dao;
	private ProdutoDao produtoDao;
	private EntregaDao entregaDao;

	public ItemEntregueServico() {
		dao = DaoFactory.criarItemEntregueDao();
		produtoDao = DaoFactory.criarProdutoDao();
		entregaDao = DaoFactory.criarEntregaDao();
	}

	public void inserirAtualizar(ItemEntregue x) throws ServicoException {
		x.setProduto(produtoDao.buscar(x.getProduto().getCodProduto()));
		x.setEntrega(entregaDao.buscar(x.getEntrega().getCodEntrega()));

		if (existeItem(x.getEntrega(), x.getProduto())) {
			throw new ServicoException("O produto selecionado já está contido na entrega", 1);
		}
		
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			x.getEntrega().addItemEntregue(x);
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	
	private boolean existeItem(Entrega e, Produto p) {
		for (ItemEntregue ie : e.getItens()) {
			if (ie.getProduto() == p) {
				return true;
			}
		}
		return false;
	}
	
	
	public void excluir(ItemEntregue x) {
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ItemEntregue buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<ItemEntregue> buscarTodos() {
		return dao.buscarTodos();
	}

	public void validar(ItemEntregue x) throws ValidacaoException {
		
	}
}
