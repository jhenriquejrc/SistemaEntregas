
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/clientes/listar")
public class ItemListarClientes extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/incluirItem/listarClientes.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ClienteServico cs = new ClienteServico();
		List<Cliente> clientes = cs.buscarTodos();
    	request.setAttribute("cliente", clientes);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}
