package web.Produto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;

@WebServlet("/produtos/filtrar")
public class ProdutoFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/produtos/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoServico ps = new ProdutoServico();
		String nome = request.getParameter("busca");
		List<Produto> produtos = ps.buscarPorNome(nome);
		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
