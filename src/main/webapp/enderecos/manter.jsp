<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Enderecos</h1>
		</div>

		<table class="table">

			<thead>
				<tr>
					<th>Nome</th>
					<th>A��o</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${clientes}" var="x">
					<tr>
						<td>${x.nome}</td>
						<td><a class="btn btn-primary"
							href="<%=request.getContextPath()%>/enderecos/listar?codCliente=${x.codCliente}">Selecionar</a></td>

					</tr>

				</c:forEach>

			</tbody>

		</table>



	</div>


<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>