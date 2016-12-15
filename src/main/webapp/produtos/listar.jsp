<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />
    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Lista de Produtos</h1>
      </div>
		<div class="row">
			<div class="col-sm-2">
				<form method="post" class="navbar-form" action="<%=request.getContextPath()%>/produtos/novo">
				<button type="submit" class="btn btn-primary" >Inserir Novo</button>
				</form>
			</div>
			
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/produtos/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite o nome de um produto" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>
			
		</div>
		<table class="table">

			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preço</th>
					<th>Fornecedor</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${produtos}" var="x">
					<tr>
						<td>${x.codProduto}</td>
						<td>${x.nome}</td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.preco}" /></td>					
						<td>${x.fornecedor.nome}</td>
						<td><a href="<%=request.getContextPath()%>/produtos/editar?codProduto=${x.codProduto}" class="btn btn-primary btn-xs">Editar</a>
						<a href="<%=request.getContextPath()%>/produtos/remover?codProduto=${x.codProduto}" class="btn btn-danger btn-xs">Excluir</a></td>
					</tr>

				</c:forEach>

			</tbody>

		</table>
		


    </div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>