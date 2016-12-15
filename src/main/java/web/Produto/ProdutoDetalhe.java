package web.Produto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;

@WebServlet("/produtos/detalhes")
public class ProdutoDetalhe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/produtos/produtosDetalhes.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoServico fs = new ProdutoServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Produto x = fs.buscar(cod);
		x.getFornecedor();
		request.setAttribute("item", x);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}