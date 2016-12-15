<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Editar Endereço</h1>
		</div>

		<form name="myform" class="form-horizontal" action="">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="logadouro">Logadouro:</label>
				<div class="col-sm-5">
					<input type="text" name="logadouro" id="logadouro"
						value="${item.logadouro}" required="required" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="numero">Numero:</label>
				<div class="col-sm-5">
					<input type="text" name="numero" id="numero" value="${item.numero}"
						required="required" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="complemento">Complemento:</label>
				<div class="col-sm-5">
					<input type="text" name="complemento" id="complemento"
						value="${item.complemento}" required="required"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="bairro">Bairro:</label>
				<div class="col-sm-5">
					<input type="text" name="bairro" id="bairro" value="${item.bairro}"
						required="required" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cep">Cep:</label>
				<div class="col-sm-5">
					<input type="text" name="cep" id="cep" value="${item.cep}"
						required="required" class="form-control" />
				</div>
			</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<form class="navbar-form" action="<%=request.getContextPath()%>/enderecos/atualizar">
						<button type="submit" class="btn btn-primary" >Atualizar</button>
						</form>
						<a href="<%=request.getContextPath()%>/manter/enderecos" class="btn btn-default">Voltar</a>
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