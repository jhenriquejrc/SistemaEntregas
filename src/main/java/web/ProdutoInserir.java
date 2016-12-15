package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Produto;
import servico.ProdutoServico;
import servico.ServicoException;
import servico.ValidacaoException;


@WebServlet("/produtos/inserir")
public class ProdutoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/produtos/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	private static String FORM = "/produtos/formInserir.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdutoServico ps = new ProdutoServico();
		Produto x = Instanciar.produto(request);
		
		try {
			ps.validar(x);
			ps.inserir(x);
			List<Produto> itens = ps.buscarTodos();
			request.setAttribute("produtos", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
			}
		catch (ServicoException e){
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			List<Produto> produtos = ps.buscarTodos();
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.setAttribute("produtos", produtos);
			request.getRequestDispatcher(FORM).forward(request, response);
		} 
	}
}

