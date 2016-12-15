<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script>
$('.datepicker').datepicker();

</script>

<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Novo Fornecedor</h1>
		</div>

		<form method="post" name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/fornecedores/inserir">


			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<ul>
					<c:forEach items="${erros}" var="msg">
						<li class="erro">${msg}</li>
					</c:forEach>
				</ul>
			</div>
		</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome" value="${item.nome}"
					class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cnpj">CNPJ:</label>
				<div class="col-sm-5">
					<input type="text" name="cnpj" id="cnpj" value="${item.cnpj}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="email">Email:</label>
				<div class="col-sm-5">
					<input type="text" name="email" id="email" 
						value="${item.email}" 
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="fone">Fone:</label>
				<div class="col-sm-5">
					<input type="text" name="fone" id="fone" value="${item.fone}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="faturamento">Faturamento Anual:</label>
				<div class="col-sm-5">
					<input type="text" name="faturamento" id="faturamento" value="${item.faturamentoAnual}"
						required="required" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/fornecedores/listar"
						class="btn btn-default">Voltar</a>
				</div>
			</div>

		</form>

	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
	<script>
      $(document).ready(function () {
        $('#dataCadastro').datepicker({
            format: "dd/mm/yyyy",
            language: "pt-BR"
        });
      });
    </script>
		
</body>
</html>