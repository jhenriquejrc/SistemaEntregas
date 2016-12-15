package web;

import dominio.Produto;
import servico.ProdutoServico;
import servico.ServicoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@WebServlet("/produtos/excluir")
public class ProdutoExcluir extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String DESTINO = "/produtos/listar.jsp";
    private static String ERRO = "/publico/erro.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	ProdutoServico ps = new ProdutoServico();
    	int cod = Integer.parseInt(request.getParameter("codProduto"));
    	Produto p = ps.buscar(cod);
    	
    	try {
			ps.excluir(p);
			List<Produto> produtos = ps.buscarTodos();
			request.setAttribute("produtos", produtos);
	    	request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} 

    }

}