package dao;

import java.util.List;

import dominio.Entrega;

public interface EntregaDao {

	public void inserirAtualizar(Entrega x);
	public void excluir(Entrega x);
	public Entrega buscar(int cod);
	public List<Entrega> buscarTodos();
	public List<Entrega> buscarEntregaCliente(int codCliente);
} 
