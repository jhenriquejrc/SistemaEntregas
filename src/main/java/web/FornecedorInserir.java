package web;

import dominio.Endereco;
import dominio.Fornecedor;
import servico.EnderecoServico;
import servico.FornecedorServico;
import servico.ServicoException;
import servico.ValidacaoException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fornecedor/inserir")
public class FornecedorInserir extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/fornecedor/listar";
    private static String FORM = "/fornecedor/formInserir.jsp";
	private static String ERRO = "/publico/erro.jsp";
  	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Fornecedor x = null;
    	FornecedorServico fs = new FornecedorServico();
    	
    	try {
    		x = Instanciar.fornecedor(request);
			fs.validar(x);
			fs.inserirAtualizar(x);
	    	response.sendRedirect(request.getContextPath()+DESTINO);
		} catch (ValidacaoException e) {
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		} catch (ServicoException e) {
			e.printStackTrace();
		}

	}

}