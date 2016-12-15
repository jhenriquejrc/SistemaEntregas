
package web.Endereco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/manter/enderecos")
public class ManterEnderecos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/manter.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ClienteServico cs = new ClienteServico();
    	List<Cliente> clientes = cs.buscarTodos();
    	request.setAttribute("clientes", clientes);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}
