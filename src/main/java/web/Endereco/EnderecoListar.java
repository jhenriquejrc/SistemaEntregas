
package web.Endereco;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/enderecos/listar")
public class EnderecoListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/listar.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ClienteServico cs = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("codCliente"));
		Cliente x = cs.buscar(cod);
    	request.setAttribute("enderecos", x.getEnderecos());
    	request.setAttribute("cliente", x);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}
