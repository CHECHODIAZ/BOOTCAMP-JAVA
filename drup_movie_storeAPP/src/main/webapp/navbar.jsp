

<header>
	<nav class="navbar navbar-expand-lg navbar-gray bg-light shadow p-3 mb-5 bg-body rounded">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">Inicio</a> 
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="formulario-actualizacion.jsp">Actualizar
							contenido</a></li>
					<li class="nav-item"><a class="nav-link" href="registro-material.jsp">Crear
							material</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/peliculasinfantiles">Películas infantiles</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/ListServlet">Buscar lista</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/formulario-especial.jsp">Busqueda especial</a>
					</li>
					
				</ul>
				<form class="d-flex"
					action="<%=request.getContextPath()%>/MovieSearchServlet" method="get">
					<input class="form-control me-2" name="SEARCH" type="search"
						placeholder="titulo, genero, director" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
				<br> <a class="btn btn-primary"
					href="<%=request.getContextPath()%>/LogoutServlet?accion=cerrar"
					role="button">Salir</a>
			</div>
		</div>
	</nav>
</header>
