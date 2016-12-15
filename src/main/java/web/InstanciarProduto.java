package web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import dominio.Fornecedor;
import dominio.Produto;

public class InstanciarProduto {

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
			aux.setFornecedor(new Fornecedor());
		}
		return aux;
		
	}
}
