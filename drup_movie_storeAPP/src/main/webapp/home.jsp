<%@page contentType = "text/html" pageEncoding="UTF-8" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session = "true" %>
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

<title>Home</title>
</head>

<body>
	<nav>
		<jsp:include page="navbar.jsp" />
	</nav>

	<main bg-light>
		<section></section>
		<section class="container-fluid">
			<div class="row">
				<div class="col">
					<div class="input-group mb-1">
					 
					</div>
					<h2>Te damos la bienvenida... <%=request.getSession().getAttribute("OKSESSION")%>.</h2>
					<div class="row m-0 justify-content-center align-items-center vh-50"><img alt="" src="<%=request.getContextPath()%>/img/home.jpg" style="width: 24rem; height: 22rem"></div>
					
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
