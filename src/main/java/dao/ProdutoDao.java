package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Produto;

public interface ProdutoDao {

	public void inserirAtualizar(Produto x);
	public void excluir(Produto x);
	public Produto buscar(int cod);
	public List<Produto> buscarTodos();
	
	public List<Produto> buscaNomePreco(String nome, BigDecimal valorMin, BigDecimal valorMax);
	public Produto buscaNomeExatoDiferente(Integer codProduto, String nome);
	public Produto buscaNomeExato(String nome);
	public List<Produto> buscarPorNome(String nome);
} 
