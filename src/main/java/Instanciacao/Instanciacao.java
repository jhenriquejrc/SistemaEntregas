package Instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Endereco;
import dominio.Entrega;
import dominio.Fornecedor;
import dominio.ItemEntregue;
import dominio.Produto;
import servico.ClienteServico;
import servico.EnderecoServico;
import servico.EntregaServico;
import servico.FornecedorServico;
import servico.ItemEntregueServico;
import servico.ProdutoServico;
import servico.ServicoException;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		Cliente c1 = new Cliente(null, "Caio", "caio.rod18@gmail.com", "09535194658");
		Cliente c2 = new Cliente(null, "Andre", "andre.rod@gmail.com", "09524944658");
		Cliente c3 = new Cliente(null, "Lucas", "lucas.rod@gmail.com", "09543219465");
		
		Endereco e1 = new Endereco(null, "Rua 1", 452, "AP", "Sao judas", "35610000", c1);
		Endereco e2 = new Endereco(null, "Rua Osvaldo Rodrigues", 600, "AP", "Daniel fonseca", "34231236", c1);
		
		Endereco e3 = new Endereco(null, "Rua Neto Campos", 555, "AP", "Niteroi", "45435354", c2);
		Endereco e4 = new Endereco(null, "Rua 2", 672, "AP", "Interlagos", "35610000", c2);
		
		Endereco e5 = new Endereco(null, "Rua 1", 373, "AP", "Martins", "324324234", c3);
		Endereco e6 = new Endereco(null, "Rua Mario Freitas", 1243, "AP", "Centro", "465754634", c3);
		
		Fornecedor f1 = new Fornecedor(null, "Rodrigo", "2342424", "994347242", "rodrigo.forn@hotmail.com", new BigDecimal ("20000.00"), sdf.parse("11/08/2010"));
		Fornecedor f2 = new Fornecedor(null, "Joao", "242342423", "99324545", "jao.forn@hotmail.com", new BigDecimal ("20000.00"), sdf.parse("01/10/2013"));
		Fornecedor f3 = new Fornecedor(null, "Jose", "6456453", "994234234", "j.forn@hotmail.com", new BigDecimal ("20000.00"), sdf.parse("20/04/2007"));
		
		
		Produto p1 = new Produto(null, "Caixa", new BigDecimal ("200.00"), f1);
		Produto p2 = new Produto(null, "Madeira", new BigDecimal ("560.00"), f2);
		Produto p3 = new Produto(null, "Ferro", new BigDecimal ("340.00"), f3);
		Produto p4 = new Produto(null, "Leite", new BigDecimal ("20.00"), f1);
		Produto p5 = new Produto(null, "Computador", new BigDecimal ("4000.00"), f1);
		Produto p6 = new Produto(null, "Salgado", new BigDecimal ("25.00"), f2);
		Produto p7 = new Produto(null, "Pizza", new BigDecimal ("38.00"), f3);
		Produto p8 = new Produto(null, "Suco", new BigDecimal ("10.00"), f2);
		
		Entrega en1 = new Entrega(null, sdf.parse("11/08/2016"), e1);
		Entrega en2 = new Entrega(null, sdf.parse("20/08/2016"), e4);
		Entrega en3 = new Entrega(null, sdf.parse("21/08/2016"), e2);
		Entrega en4 = new Entrega(null, sdf.parse("27/08/2016"), e6);
		Entrega en5 = new Entrega(null, sdf.parse("30/08/2016"), e3);
		
		ItemEntregue i1 = new ItemEntregue(null, 2, p1, en1);
		ItemEntregue i2 = new ItemEntregue(null, 4, p2, en1);

		ItemEntregue i3 = new ItemEntregue(null, 3, p3, en2);
		ItemEntregue i4 = new ItemEntregue(null, 7, p4, en2);
		
		ItemEntregue i5 = new ItemEntregue(null, 2, p5, en3);
		ItemEntregue i6 = new ItemEntregue(null, 3, p6, en3);
		
		ItemEntregue i7 = new ItemEntregue(null, 5, p1, en4);
		ItemEntregue i8 = new ItemEntregue(null, 1, p6, en4);
		
		ItemEntregue i9 = new ItemEntregue(null, 4, p3, en5);
		ItemEntregue i10 = new ItemEntregue(null, 9, p5, en5);
		
		ClienteServico cs = new ClienteServico();
		EnderecoServico es = new EnderecoServico();
		FornecedorServico fs = new FornecedorServico();
		ProdutoServico ps = new ProdutoServico();
		EntregaServico ens = new EntregaServico();
		ItemEntregueServico ies = new ItemEntregueServico();
		
		cs.inserirAtualizar(c1);
		cs.inserirAtualizar(c2);
		cs.inserirAtualizar(c3);
		
		es.inserir(e1);
		es.inserir(e2);
		es.inserir(e3);
		es.inserir(e4);
		es.inserir(e5);
		es.inserir(e6);
		
		fs.inserirAtualizar(f1);
		fs.inserirAtualizar(f2);
		fs.inserirAtualizar(f3);
		
		ps.inserir(p1);
		ps.inserir(p2);
		ps.inserir(p3);
		ps.inserir(p4);
		ps.inserir(p5);
		ps.inserir(p6);
		ps.inserir(p7);
		ps.inserir(p8);
		
		ens.inserirAtualizar(en1);
		ens.inserirAtualizar(en2);
		ens.inserirAtualizar(en3);
		ens.inserirAtualizar(en4);
		ens.inserirAtualizar(en5);
		
		ies.inserirAtualizar(i1);
		ies.inserirAtualizar(i2);
		ies.inserirAtualizar(i3);
		ies.inserirAtualizar(i4);
		ies.inserirAtualizar(i5);
		ies.inserirAtualizar(i6);
		ies.inserirAtualizar(i7);
		ies.inserirAtualizar(i8);
		ies.inserirAtualizar(i9);
		ies.inserirAtualizar(i10);

		
		
		
		response.getWriter().append("Pronto");
	}
		catch (ParseException e) {
			response.getWriter().append("Erro ao instanciar data");
		}
		
		catch (ServicoException e) {
			response.getWriter().append("Erro no serviço.");
		}
	
	}
}