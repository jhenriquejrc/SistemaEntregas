	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Pesquisar Produtos</h1>
		</div>

		<form method="get" name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/produtos/resultado">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome" value=""
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="valorMin">Preço mínimo:</label>
				<div class="col-sm-5">
					<input type="number" name="valorMin" id="valorMin"
						value="" required="required"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="valorMax">Preço máximo:</label>
				<div class="col-sm-5">
					<input type="number" name="valorMax" id="valorMax"
						value="" required="required"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Pesquisar</button>
					<a href="<%=request.getContextPath()%>"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>