package dao;


import impl.ClienteDaoImpl;
import impl.EnderecoDaoImpl;
import impl.EntregaDaoImpl;
import impl.FornecedorDaoImpl;
import impl.ItemEntregueDaoImpl;
import impl.ProdutoDaoImpl;
import dominio.Produto;

public class DaoFactory {

	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}

	public static EnderecoDao criarEnderecoDao() {
		return new EnderecoDaoImpl();
	}

	public static FornecedorDao criarFornecedorDao() {
		return new FornecedorDaoImpl();
	}

	public static EntregaDao criarEntregaDao() {
		return new EntregaDaoImpl();
	}
	
	public static ItemEntregueDao criarItemEntregueDao() {
		return new ItemEntregueDaoImpl();
	}
	
	public static ProdutoDaoImpl criarProdutoDao() {
		return new ProdutoDaoImpl();
	}
}
