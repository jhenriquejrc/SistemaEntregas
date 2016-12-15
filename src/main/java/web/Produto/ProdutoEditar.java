
package web.Produto;

import dominio.Fornecedor;
import dominio.Produto;
import servico.FornecedorServico;
import servico.ProdutoServico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos/editar")
public class ProdutoEditar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static String DESTINO = "/produtos/formEditar.jsp";
  	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ProdutoServico ps = new ProdutoServico();
    	int cod = Integer.parseInt(request.getParameter("codProduto"));
    	Produto p = ps.buscar(cod);
		FornecedorServico fs = new FornecedorServico();
		List<Fornecedor> fornecedores = fs.buscarTodos();
    	request.setAttribute("produto", p);
		request.setAttribute("fornecedores", fornecedores);
		request.setAttribute("fornecedor", p.getFornecedor());
    	request.getRequestDispatcher(DESTINO).forward(request, response);
    	
   	 
    }

}