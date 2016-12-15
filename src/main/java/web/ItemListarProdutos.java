
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Produto;
import servico.ClienteServico;
import servico.ProdutoServico;

@WebServlet("/produtos/listar")
public class ItemListarProdutos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/incluirItem/listaProdutos.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	ProdutoServico ps = new ProdutoServico();
    	Integer codEntrega = Integer.parseInt(request.getParameter("codEntrega"));
		List<Produto> produtos = ps.buscarTodos();
		request.setAttribute("codEntrega", codEntrega);
    	request.setAttribute("produto", produtos);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}
