<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

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

<title>tabla_eliminar</title>
</head>

<body>


	<nav>
		<jsp:include page="navbar.jsp" />
	</nav>

	<main>
		<section>
		</section>
		<section class="container-fluid">
			<div class="row">
				<div class="col">
					<h2>Listado de Películas</h2>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">TITULO</th>
								<th scope="col">GENERO</th>
								<th scope="col">DIRECTOR</th>
								<th scope="col">RESUMEN</th>
							</tr>
						</thead>
						<tbody>
							<%
							Object search = request.getAttribute("SPECIALSEARCH");
							List<Object> obj = (List<Object>) search;
							%>
							<tr>
								<td><%=obj.get(0)%></td>
								<td><%=obj.get(1)%></td>
								<td><%=obj.get(2)%></td>
								<td><%=obj.get(3)%></td>
								<td><form class="row g-3"
										action="<%=request.getContextPath()%>/DeleteServlet"
										method="post">
										<div class="col-auto">
											<label for="inputPassword2" class="visually-hidden">comfirmar
												id</label> <input type="number" name="DELETESEARCH"
												class="form-control" placeholder="Comfirmar Id">
										</div>
										<div class="col-auto">
											<button type="submit" class="btn btn-primary mb-3">Eliminar</button>
										</div></td>
								</form>
							</tr>
						</tbody>
					</table>
				</div>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</body>

</html>

<%
}else{
response.sendRedirect("index.jsp");
}
%>