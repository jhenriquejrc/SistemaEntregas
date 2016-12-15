package servico;

import java.util.List;

import dao.DaoFactory;
import dao.EntregaDao;
import dao.Transaction;
import dominio.Entrega;

public class EntregaServico {

	private EntregaDao dao;
	
	public EntregaServico() {
		dao = DaoFactory.criarEntregaDao();
	}
	
	public void inserirAtualizar(Entrega x) {
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			}
			catch (RuntimeException e) {
				if (Transaction.isActive()){
					Transaction.rollback();
				}
				System.out.println("Erro: " + e.getMessage());
			}
		}
	
	public void excluir(Entrega x) {
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
			}
			catch (RuntimeException e) {
				if (Transaction.isActive()){
					Transaction.rollback();
				}
				System.out.println("Erro: " + e.getMessage());
			}
		}
	
	public Entrega buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Entrega> buscarTodos() {
		return dao.buscarTodos();
	}
}
