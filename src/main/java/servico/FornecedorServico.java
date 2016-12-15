package servico;

import dao.DaoFactory;
import dao.FornecedorDao;
import dao.Transaction;
import dominio.Fornecedor;
import dominio.Produto;

import java.util.LinkedList;
import java.util.List;

public class FornecedorServico {

    private FornecedorDao dao;

    public FornecedorServico() {
        dao = DaoFactory.criarFornecedorDao();
    }

    public void inserir(Fornecedor x) throws ServicoException {
        try {
            Fornecedor aux = dao.existeFornecedor(x.getCnpj());
            if (aux != null) {
                throw new ServicoException("CNPJ já existe", 0);
            }
            Transaction.begin();
            dao.inserirAtualizar(x);
            Transaction.commit();
        } catch (RuntimeException e) {
            if (Transaction.isActive()) {
                Transaction.rollback();
            }
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void atualizar(Fornecedor x) throws ServicoException {
        try {
            
            Transaction.begin();
            dao.inserirAtualizar(x);
            Transaction.commit();
        } catch (RuntimeException e) {
            if (Transaction.isActive()) {
                Transaction.rollback();
            }
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluir(Fornecedor x) throws ServicoException {
        try {
            List<Produto> prod = x.getProdutos();
            if (prod.size() > 0) {
                throw new ServicoException("Não é possível excluir! Já existe produto(s) para esse Fornecedor", 0);
            }
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

    public Fornecedor buscar(int cod) {
        return dao.buscar(cod);
    }


    public List<Fornecedor> buscarTodos() {
        return dao.buscarTodos();
    }

    public void validar(Fornecedor x) throws ValidacaoException {
        List<String> erros = new LinkedList<>();

        if (x.getNome() == null) {
            erros.add("Favor preencher o nome!");
        }

        if (x.getCnpj() == null) {
            erros.add("Favor preencher o CNPJ!");
        }

        if (x.getFone() == null) {
            erros.add("Favor preencher o fone!");
        }

        if (x.getEmail() == null) {
            erros.add("Favor preencher o Email!");
        }

        if (x.getFaturamentoAnual() == null) {
            erros.add("Favor preencher o faturamento anual!");
        }

        if (!erros.isEmpty()) {
            throw new ValidacaoException("Erro de validacao do endereco", erros);
        }
    }

    public List<Fornecedor> buscarFornecedor(String nome) {
        return dao.buscarFornecedor(nome);
    }
}