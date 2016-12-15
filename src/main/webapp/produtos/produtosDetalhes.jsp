<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes do Produto</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">C�digo: ${item.codProduto}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Pre�o: ${item.preco}</li>
				<li class="list-group-item">Nome do Fornecedor: ${item.fornecedor.nome}</li>
				<li class="list-group-item">Telefone do Fornecedor: ${item.fornecedor.fone}</li>
				<li class="list-group-item">Email do Fornecedor: ${item.fornecedor.email}</li>
			</ul>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>