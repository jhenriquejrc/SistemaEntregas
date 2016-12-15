
package web.Fornecedor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Fornecedor;

@WebServlet("/fornecedores/novo")
public class FornecedorNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/fornecedores/formInserir.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fornecedor forn = new Fornecedor();
		request.setAttribute("item", forn);
		request.getRequestDispatcher(DESTINO).forward(request, response);

		
	}

}
