package web.Fornecedor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Fornecedor;
import servico.FornecedorServico;

@WebServlet("/fornecedores/remover")
public class FornecedorRemover extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/fornecedores/confirmarExclusao.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	FornecedorServico fs = new FornecedorServico();
    	int cod = Integer.parseInt(request.getParameter("codFornecedor"));
    	Fornecedor forn = fs.buscar(cod);
    	request.setAttribute("item", forn);
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}