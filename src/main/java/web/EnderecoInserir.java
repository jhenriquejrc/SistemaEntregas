package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Endereco;
import servico.EnderecoServico;
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/enderecos/inserir")
public class EnderecoInserir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/enderecos/listar?codCliente=";
    private static String FORM = "/enderecos/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
  	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Endereco x = null;
    	EnderecoServico es = new EnderecoServico();
    	int y = Integer.parseInt(request.getParameter("codCliente"));
    	
    	try {
    		x = Instanciar.endereco(request);
			es.validar(x);
			es.inserir(x);
	    	response.sendRedirect(request.getContextPath()+DESTINO+y);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		} 
   	 
    }

}