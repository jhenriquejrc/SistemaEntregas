package dao;

import java.util.List;

import dominio.Fornecedor;

public interface FornecedorDao {

	public void inserirAtualizar(Fornecedor x);
	public void excluir(Fornecedor x);
	public Fornecedor buscar(int cod);
	public List<Fornecedor> buscarTodos();
	public Fornecedor existeFornecedor(String cnpj);
	public List<Fornecedor> buscarFornecedor(String nome);
} 
