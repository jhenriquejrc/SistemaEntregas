package web;

import dominio.Produto;
import servico.ProdutoServico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produtos/remover")
public class ProdutoRemover extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/produtos/confirmarExclusao.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ProdutoServico ps = new ProdutoServico();
    	int cod = Integer.parseInt(request.getParameter("codProduto"));
    	Produto e = ps.buscar(cod);
    	request.setAttribute("item", e);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}