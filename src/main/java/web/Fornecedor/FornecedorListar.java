
package web.Fornecedor;

import dominio.Fornecedor;
import servico.FornecedorServico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fornecedor/listar")
public class FornecedorListar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String DESTINO = "/fornecedores/listar.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FornecedorServico fs = new FornecedorServico();
        List<Fornecedor> fornecedores = fs.buscarTodos();
        request.setAttribute("fornecedores", fornecedores);
        request.getRequestDispatcher(DESTINO).forward(request, response);


    }

}
