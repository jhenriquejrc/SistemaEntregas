
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Endereco;
import servico.EnderecoServico;

@WebServlet("/enderecos/editar")
public class EnderecoEditar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/formEditar.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	EnderecoServico es = new EnderecoServico();
    	int cod = Integer.parseInt(request.getParameter("codEndereco"));
    	Endereco end = es.buscar(cod);
    	request.setAttribute("item", end);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}
