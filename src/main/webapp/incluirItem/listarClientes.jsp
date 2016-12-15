<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Filmes</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/resources/templates/navbar.jsp" />

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Lista de Clientes</h1>
      </div>
		<div class="row">
		</div>
		<table class="table">

			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Email</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${cliente}" var="x">
					<tr>
						<td>${x.codCliente}</td>
						<td>${x.nome}</td>
						<td>${x.cpf}</td>
						<td>${x.email}</td>
						<td><a href="<%=request.getContextPath()%>/entregas/listar?codCliente=${x.codCliente}" class="btn btn-primary btn-xs">Inserir</a></td>
					</tr>

				</c:forEach>

			</tbody>

		</table>
		


    </div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>