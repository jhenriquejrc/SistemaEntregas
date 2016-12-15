
package web.Endereco;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Endereco;
import servico.EnderecoServico;
import servico.ServicoException;

@WebServlet("/enderecos/excluir")
public class EnderecoExcluir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/listar?codCliente=";
    private static String ERRO = "/publico/erro.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
    		EnderecoServico es = new EnderecoServico();
        	int cod = Integer.parseInt(request.getParameter("codEndereco"));
        	Endereco end = es.buscar(cod);
        	int codCli = end.getCliente().getCodCliente();
			es.excluir(end);
			request.getRequestDispatcher(DESTINO+codCli).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
    	
    }

}