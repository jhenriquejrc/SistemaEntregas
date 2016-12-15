
package web.Produto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Fornecedor;
import dominio.Produto;
import servico.FornecedorServico;

@WebServlet("/produtos/novo")
public class ProdutoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/produtos/formInserir.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FornecedorServico fs = new FornecedorServico();
		Produto p = new Produto();
		List<Fornecedor> fornecedores = fs.buscarTodos();
		request.setAttribute("item", p);
		request.setAttribute("fornecedores", fornecedores);
		request.getRequestDispatcher(DESTINO).forward(request, response);

		
	}

}
