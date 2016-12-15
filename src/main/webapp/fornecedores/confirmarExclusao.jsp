<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Confirmar Exclus�o</h1>

			<ul class="list-group">
				<li class="list-group-item">C�digo: ${item.codFornecedor}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">CNPJ: ${item.cnpj}</li>
				<li class="list-group-item">Email: ${item.email}</li>
				<li class="list-group-item">Fone: ${item.fone}</li>
				<li class="list-group-item">Faturamento Anual: ${item.faturamentoAnual}</li>
				<li class="list-group-item">Data de Cadastro: ${item.dataCadastro}</li>
				
			</ul>

			<div>
				<a
					href="<%=request.getContextPath()%>/fornecedores/excluir?codFornecedor=${item.codFornecedor}"
					class="btn btn-danger">Excluir</a> <a
					href="<%=request.getContextPath()%>/fornecedores/listar"
					class="btn btn-default">Voltar</a>
			</div>

		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>