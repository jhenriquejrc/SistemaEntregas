
package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Endereco;
import servico.ClienteServico;

@WebServlet("/enderecos/novo")
public class EnderecoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/enderecos/formInserir.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteServico cs = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("codCliente"));
		Endereco x = new Endereco();
		Cliente c = cs.buscar(cod);
		x.setCliente(c);
		request.setAttribute("item", x);
		request.getRequestDispatcher(DESTINO).forward(request, response);

		
	}

}