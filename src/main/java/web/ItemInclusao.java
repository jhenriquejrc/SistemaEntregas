
package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Entrega;
import dominio.ItemEntregue;
import servico.ItemEntregueServico;
import servico.ServicoException;

@WebServlet("/entregas/inclusao")
public class ItemInclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/incluirItem/listaInclusao.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ItemEntregue x = null;
		ItemEntregueServico ies = new ItemEntregueServico();

		try {
			x = Instanciar.item(request);
			ies.inserirAtualizar(x);
			Entrega y = x.getEntrega();
			request.setAttribute("entrega", y);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} 
	}

}
