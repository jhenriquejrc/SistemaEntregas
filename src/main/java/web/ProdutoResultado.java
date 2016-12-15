package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;

@WebServlet("/produtos/resultado")
public class ProdutoResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/produtos/resultadoBusca.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoServico fs = new ProdutoServico();
		String nome = request.getParameter("nome");
		BigDecimal valorMin = new BigDecimal(request.getParameter("valorMin"));
		BigDecimal valorMax = new BigDecimal(request.getParameter("valorMax"));
		List<Produto> itens = fs.buscaNomePreco(nome, valorMin, valorMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}