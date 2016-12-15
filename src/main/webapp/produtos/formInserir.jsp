<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Inserir Produto</h1>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<ul>
					<c:forEach items="${erros}" var="msg">
						<li class="erro">${msg}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<form name="myform" class="form-horizontal" method="post" action="<%=request.getContextPath()%>/produtos/inserir">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="codigo">Codigo:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="disabledInput" type="text" disabled
						   value="${produto.codProduto}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome"
						value="${produto.nome}" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="preco">Preço:</label>
				<div class="col-sm-5">
					<input type="text" name="preco" id="preco" value="${produto.preco}"
						required="required" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="codFornecedor">Selecione
					o Fornecedor:</label>
				<div class="col-sm-5">
					<select name="codFornecedor" class="form-control">
						<option value="">-- Selecione o Fornecedor --</option>
						<c:forEach items="${fornecedores}" var="x">
							<option value="${x.codFornecedor}" <c:if test="${x == fornecedorSelecionado}">selected="selected"</c:if>>
								${x.nome}  
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary" >Inserir</button>
						<a href="<%=request.getContextPath()%>/produtos/manter" class="btn btn-default">Voltar</a>
					</div>
				</div>

		</form>

	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>