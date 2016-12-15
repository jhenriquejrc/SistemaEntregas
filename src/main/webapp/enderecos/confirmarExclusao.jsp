<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Confirmar Exclusão</h1>

			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codEndereco}</li>
				<li class="list-group-item">Logadouro: ${item.logadouro}</li>
				<li class="list-group-item">Numero: ${item.numero}</li>
				<li class="list-group-item">Complemento: ${item.complemento}</li>
				<li class="list-group-item">Bairro: ${item.bairro}</li>
				<li class="list-group-item">CEP: ${item.cep}</li>
			</ul>

			<div>
				<a
					href="<%=request.getContextPath()%>/enderecos/excluir?codEndereco=${item.codEndereco}"
					class="btn btn-danger">Excluir</a> <a
					href="<%=request.getContextPath()%>/manter/enderecos"
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