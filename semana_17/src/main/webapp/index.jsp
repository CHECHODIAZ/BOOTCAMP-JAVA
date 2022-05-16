<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semana_17.entity.Carousel"%>
<%@page import="java.util.Collection"%>

<!doctype html>
<html lang="es">
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

<title>carrusel</title>
</head>
<body>	
	<h1>MI CARRUSEL!</h1>
	<section class=container-fluid>
		<div class=row>
		<a class="btn btn-primary"
		href="<%=request.getContextPath()%>/ListServlet" role="button">Ir
		a lista de imagenes</a>
			<div id="carouselExampleCaptions" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<%
						Object carr = request.getAttribute("CAROUSEL");
						%>
						<%
						Collection<List<Object>> list = (Collection<List<Object>>) carr;
						%>
						<%
						for (List<Object> obj : list) {
						%>
						<%
						if (obj.get(0).equals(1)) {
						%>
						<img src="<%=request.getContextPath()%>/img/<%=obj.get(1)%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5><%=obj.get(0)%></h5>
							<p><%=obj.get(2)%></p>
						</div>
					</div>
					<div class="carousel-item">
						<%
						}
						%>
						<%
						if (obj.get(0).equals(2)) {
						%>
						<img src="<%=request.getContextPath()%>/img/<%=obj.get(1)%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5><%=obj.get(0)%></h5>
							<p><%=obj.get(2)%></p>
						</div>
					</div>
					<div class="carousel-item">
						<%
						}
						%>
						<%
						if (obj.get(0).equals(3)) {
						%>
						<img src="<%=request.getContextPath()%>/img/<%=obj.get(1)%>"
							class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h5><%=obj.get(0)%></h5>
							<p><%=obj.get(2)%></p>
						</div>
					</div>
					<%
					}
					%>
					<%
					}
					%>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</section>


	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>