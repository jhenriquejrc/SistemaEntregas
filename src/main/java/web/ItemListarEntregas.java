
package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Endereco;
import dominio.Entrega;
import servico.ClienteServico;

@WebServlet("/entregas/listar")
public class ItemListarEntregas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/incluirItem/listaEntregas.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteServico cs = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("codCliente"));
		Cliente x = cs.buscar(cod);

		List<Entrega> lista = new ArrayList<Entrega>();
		for (Endereco end : x.getEnderecos()) {
			for (Entrega ent : end.getEntregas()) {
				lista.add(ent);
			}
		}

		request.setAttribute("entregas", lista);
		request.getRequestDispatcher(DESTINO).forward(request, response);

	}

}
