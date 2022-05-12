<%
if (request.getSession().getAttribute("OKSESSION") != null){
%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>formulario</title>
</head>

<body class="row m-1 justify-content-center align-items-center vh-100">
	<jsp:include page="navbar.jsp" />
	<main>
		<section>
			<h1 class="fw-bold">Bienvenido!</h1>
			<div class="text-center">
				<div class="card-body">
					<h2 class="card-title">Busqueda especial material</h2>
					<p class="card-text">En este espacio podras buscar y eliminar un material en especifico</p>
				</div>
			</div>
			<br> <br>
		</section>
		<section class="container-fluid">
			<div class="row">
				<div class="col">
					<form class="row g-3" action="<%=request.getContextPath()%>/OneServlet" method="get" >
						<div class="col-auto">
							<label for="inputPassword2" class="visually-hidden">Id de la pelicula</label>
							<input type="number" name="SPECIALSEARCH" class="form-control" 
								placeholder="ingrese Id pelicula">
						</div>
						<div class="col-auto">
							<button type="submit" class="btn btn-primary mb-3">Buscar</button>
						</div>
					</form>
				</div>
		</section>

	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/list-general.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</body>

</html>

<%
}else{
response.sendRedirect("index.jsp");
}
%>