package web.Fornecedor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Fornecedor;
import servico.FornecedorServico;
import servico.ServicoException;
import servico.ValidacaoException;
import web.Instanciar;


@WebServlet("/fornecedores/inserir")
public class FornecedorInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/fornecedores/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	private static String FORM = "/fornecedores/formInserir.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FornecedorServico fs = new FornecedorServico();
		Fornecedor x = Instanciar.fornecedor(request);
		
		try {
			fs.validar(x);
			fs.inserir(x);
			List<Fornecedor> itens = fs.buscarTodos();
			request.setAttribute("fornecedores", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
			}
		catch (ServicoException e){
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) {
			List<Fornecedor> fornecedores = fs.buscarTodos();
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.setAttribute("fornecedores", fornecedores);
			request.getRequestDispatcher(FORM).forward(request, response);
		} 
	}
}

