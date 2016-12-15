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
				<li class="list-group-item">C�digo: ${item.codProduto}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Pre�o: ${item.preco}</li>
				<li class="list-group-item">Fornecedor: ${item.fornecedor.nome}</li>
			</ul>

			<div>
				<a
					href="<%=request.getContextPath()%>/produtos/excluir?codProduto=${item.codProduto}"
					class="btn btn-danger">Excluir</a> <a
					href="<%=request.getContextPath()%>/produtos/manter"
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