
package web.Endereco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Endereco;
import servico.EnderecoServico;
import web.Instanciar;

@WebServlet("/enderecos/atualizar")
public class EnderecoAtualizar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/listar.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	EnderecoServico es = new EnderecoServico();
    	Endereco x = Instanciar.endereco(request);
    	es.atualizar(x);
    	List<Endereco> itens = es.buscarTodos();
    	request.setAttribute("itens", itens);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}