package web;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import dominio.Cliente;
import dominio.Endereco;
import dominio.Entrega;
import dominio.Fornecedor;
import dominio.ItemEntregue;
import dominio.Produto;
import servico.ClienteServico;
import servico.EntregaServico;
import servico.FornecedorServico;
import servico.ProdutoServico;

public class Instanciar {

	public static Endereco endereco (HttpServletRequest request) {
		Endereco aux = new Endereco();
		ClienteServico cs = new ClienteServico();
		String s;

		s = request.getParameter("codCliente");
		if(s!=null && !s.isEmpty()) {
			Cliente cli = cs.buscar(Integer.parseInt(s));
			aux.setCliente(cli);
		}
		
		s = request.getParameter("logadouro");
		if(s!=null && !s.isEmpty()) {
			aux.setLogadouro(s);
		}
		
		s = request.getParameter("numero");
		if(s!=null && !s.isEmpty()) {
			aux.setNumero(Integer.parseInt(s));
		}
		
		s = request.getParameter("complemento");
		if(s!=null && !s.isEmpty()) {
			aux.setComplemento(s);
		}
		
		s = request.getParameter("bairro");
		if(s!=null && !s.isEmpty()) {
			aux.setBairro(s);
		}
		
		s = request.getParameter("cep");
		if(s!=null && !s.isEmpty()) {
			aux.setCep(s);
		}
		return aux;
		
	}
	
	public static ItemEntregue item (HttpServletRequest request) {
		ItemEntregue aux = new ItemEntregue();
		String s;
		EntregaServico es = new EntregaServico();
		ProdutoServico ps = new ProdutoServico();
		
		s = request.getParameter("codEntrega");
		if(s!=null && !s.isEmpty()) {
			int cod = Integer.parseInt(request.getParameter("codEntrega"));
			Entrega x = es.buscar(cod);
			aux.setEntrega(x);
		}
		
		s = request.getParameter("codProduto");
		if(s!=null && !s.isEmpty()) {
			int cod = Integer.parseInt(request.getParameter("codProduto"));
			Produto x = ps.buscar(cod);
			aux.setProduto(x);
		}
		
		s = request.getParameter("quantidade");
		if(s!=null && !s.isEmpty()) {
			aux.setQuantidade(Integer.parseInt(s));
		}
		return aux;
		
	}
	
	public static Fornecedor fornecedor (HttpServletRequest request){
		Fornecedor aux = new Fornecedor();
		String s;
		FornecedorServico fs = new FornecedorServico();

		s = request.getParameter("nome");
        if(s!=null && !s.isEmpty()){
            aux.setNome(s);
        }

        s = request.getParameter("cnpj");
        if(s!=null && !s.isEmpty()){
            aux.setCnpj(s);
        }

        s = request.getParameter("fone");
        if(s!=null && !s.isEmpty()){
            aux.setFone(s);
        }

        s = request.getParameter("email");
        if(s!=null && !s.isEmpty()){
            aux.setEmail(s);
        }

        s = request.getParameter("faturamento");
        if(s!=null && !s.isEmpty()){
            aux.setFaturamentoAnual(new BigDecimal(s));
        }


        aux.setDataCadastro(Calendar.getInstance().getTime());

        return aux;
	}
	
	public static Produto produto (HttpServletRequest request) {
		Produto aux = new Produto();
		String s;
		
		s = request.getParameter("nome");
		if(s!=null && !s.isEmpty()) {
			aux.setNome(s);
		}
		
		s = request.getParameter("preco");
		if(s!=null && !s.isEmpty()) {
			aux.setPreco(new BigDecimal(s));
		}
		
		s = request.getParameter("codFornecedor");
		
		if(s!=null && !s.isEmpty()) {
			FornecedorServico fs = new FornecedorServico();
			int cod = Integer.parseInt(request.getParameter("codFornecedor"));
			Fornecedor x = fs.buscar(cod);
			aux.setFornecedor(x);
		}
		return aux;
		
	}
}
