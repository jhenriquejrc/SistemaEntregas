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

@WebServlet("/fornecedores/excluir")
public class FornecedorExcluir extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String DESTINO = "/fornecedores/listar.jsp";
    private static String ERRO = "/publico/erro.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	FornecedorServico fs = new FornecedorServico();
    	int cod = Integer.parseInt(request.getParameter("codFornecedor"));
    	Fornecedor forn = fs.buscar(cod);
    	
    	try {
			fs.excluir(forn);
			List<Fornecedor> fonecedores = fs.buscarTodos();
			request.setAttribute("fornecedores", fonecedores);
	    	request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} 

    }

}