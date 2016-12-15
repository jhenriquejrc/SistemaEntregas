<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Entregas</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/resources/templates/navbar.jsp" />

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Lista de Entregas</h1>
      </div>
		<div class="row">
		</div>
		<table class="table">

			<thead>
				<tr>
					<th>Codigo</th>
					<th>Data</th>
					<th>Valor Total</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${entregas}" var="x">
					<tr>
						<td>${x.codEntrega}</td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.data}"/></td>
						<td>${x.valorTotalDaEntrega}</td>
						<td><a href="<%=request.getContextPath()%>/produtos/listar?codEntrega=${x.codEntrega}" class="btn btn-primary btn-xs">Selecionar</a></td>
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