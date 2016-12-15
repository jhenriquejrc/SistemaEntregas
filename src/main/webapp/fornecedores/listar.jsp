<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />
    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Lista de Fornecedores</h1>
      </div>
		<div class="row">
			<div class="col-sm-2">
				<form method="post" class="navbar-form" action="<%=request.getContextPath()%>/fornecedores/novo">
				<button type="submit" class="btn btn-primary" >Inserir Novo</button>
				</form>
			</div>
			
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/fornecedores/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Procurar por" class="form-control"/>
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
					<th>CNPJ</th>
					<th>Fone</th>
					<th>Email</th>
					<th>Data Cadastro</th>
					<th>Faturamento Anual</th>
					<th>Ação</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${fornecedores}" var="x">
					<tr>
						<td>${x.codFornecedor}</td>
						<td>${x.nome}</td>
						<td>${x.cnpj}</td>
						<td>${x.fone}</td>
						<td>${x.email}</td>
                       <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.dataCadastro}"/></td>
                       <td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.faturamentoAnual}" /></td>
						<td><a href="<%=request.getContextPath()%>/fornecedores/editar?codFornecedor=${x.codFornecedor}" class="btn btn-primary btn-xs">Editar</a>
						<a href="<%=request.getContextPath()%>/fornecedores/remover?codFornecedor=${x.codFornecedor}" class="btn btn-danger btn-xs">Excluir</a></td>
					</tr>

				</c:forEach>

			</tbody>

		</table>
		


    </div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>