<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />
	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes da Entrega</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${entrega.codEntrega}</li>
				<li class="list-group-item">Data: <fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${entrega.data}" /></li>
				<li class="list-group-item">Valor Atualizado: ${entrega.valorTotalDaEntrega}</li>
			</ul>
		</div>
	</div>
	
	<div class="container">
		<div class="page-header">
				<h2>Itens da Entrega</h2>
		</div>

		<div>
			<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Preço</th>
					<th>Quantidade</th>
					<th>Sub Total do Pedido</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${entrega.itens}" var="x">
					<tr>
						<td>${x.produto.nome}</td>
						<td>${x.produto.preco}</td>
						<td>${x.quantidade}</td>
						<td>${x.subTotalDoItem}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>