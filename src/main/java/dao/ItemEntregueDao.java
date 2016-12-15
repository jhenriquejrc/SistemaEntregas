package dao;

import java.util.List;

import dominio.Entrega;
import dominio.ItemEntregue;
import dominio.Produto;

public interface ItemEntregueDao {

	public void inserirAtualizar(ItemEntregue x);
	public void excluir(ItemEntregue x);
	public ItemEntregue buscar(int cod);
	public List<ItemEntregue> buscarTodos();
	ItemEntregue buscaItensEntrega(Produto p, Entrega e);
} 
