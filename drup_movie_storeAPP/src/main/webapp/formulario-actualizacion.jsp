
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Registro-usuarios</title>
  </head>
  
  <body class="row m-1 justify-content-center align-items-center vh-100" >
  <jsp:include page="navbar.jsp"/>
    <main>
        <section>
        <h1 class="fw-bold">Bienvenido!</h1>
			<div class="text-center">
				<div class="card-body">
					<h2 class="card-title">Actualizacion material audiovisual</h2>
					<p class="card-text">Por favor complete datos en los siguientes campos y presione enviar para guardar la información</p>
				</div>
			</div>
			<br>
			<br>
		</section>
        <section class="container-fluid">   
            <div class="row"> 
				<div class="col">
					 <form class="row g-3 needs-validation" action="<%=request.getContextPath()%>/UpdateServlet" method="post">
						<div class="col-md-6">
							<label class="form-label">Titulo</label> <input type="text"
								name="NAMEUP" class="form-control" 
								required>
							<div class="valid-feedback"></div>
						</div>
						<div class="col-md-6">
							<label class="form-label">Director</label> <input type="text"
								name="DIRECTORUP" class="form-control" id="validationCustom02"
								 required>
							<div class="valid-feedback"></div>
						</div>
                         <div class="col-md-3">
							<label class="form-label">Genero</label> <select
								class="form-select" name="GENDERUP" id="validationCustom04"
								required>
								<option selected disabled value="">Selecciona</option>
								<option>Terror</option>
								<option>Misterio</option>
								<option>Accion</option>
								<option>Belica</option>
								<option>Ciencia ficcion</option>
								<option>Aventura</option>
								<option>Drama</option>
								<option>Suspenso</option>
								<option>Otro</option>
							</select>
						</div>
						<div class="col-md-7">
							<label class="form-label" Style=>Breve Descripción</label> <input
								type="text" name="SUMMARYUP" class="form-control ">
						</div>
						<div class="col-md-2">
							<label for="validationCustom05" class="form-label">Id material</label> <input
								type="number" name="IDUP" class="form-control"
								id="validationCustom05" required>
						</div>
						<div class="col-12">
							<button class="btn btn-primary" type="submit">Enviar</button>
						</div>
					</form>
				</div>
        </section>
    
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/list-general.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  </body>
  
</html>
<%
}else{
response.sendRedirect("index.jsp");
}
%>