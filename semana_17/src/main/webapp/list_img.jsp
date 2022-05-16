<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semana_17.entity.Carousel"%>
<%@page import="java.util.Collection"%>
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

<title>tabla_img_carousel</title>
<script type="text/javascript">

function guardarId(id) {
	//tomar el hidden que esta en el form y actualizar su value con id
	document.getElementById('idImagenEliminar').value = id;
	//console.log(document.getElementById('idImagenEliminar').value);
}

async function editar(id) {
	const options = {
	  keyboard: false
	};
	
	//hace la peticion asincrona (ajax) 
	let ImagenJson = await axios.get(`<%=request.getContextPath()%>/ActualizarParseado?id=${id}`);
	ImagenJson = ImagenJson.data;
	
	const caroulsel = ImagenJson.carousel;
	
	//tomo el input con id='id' y actualizo su valor con articuloJson.id
	document.getElementById('idImagen').value = carousel.id;
	document.getElementById('id').innerHTML = carousel.id;
	document.getElementById('url').value = carousel.imagen;
	document.getElementById('descripcion').value = carousel.descripcion;
	
	const myModal = new bootstrap.Modal(document.getElementById('modalActualizarImagen'),options)
	myModal.show();
	//usar libreria de axios para pedir informacion al servidor
	
	// voy a obtener el json que retorna
	
	//actualizar el form que está en el modal
	
	//tomando los atributos del json y 

} 
</script>

</head>
<body>
	<section class=container-fluid>
		<div class=row>
			<a class="btn btn-primary"
				href="<%=request.getContextPath()%>/servlet" role="button">Ir a
				carrusel</a>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">IMAGEN</th>
						<th scope="col">URL</th>
						<th scope="col">DESCRIPCION</th>
					</tr>
				</thead>
				<tbody>
					<% Object carr = request.getSession().getAttribute("CAROUSEL"); %>
					<% Collection<List<Object>> list = (Collection<List<Object>>)carr;%>
					<% for(List<Object> obj : list) { %>

					<tr>
						<th scope="row"><%=obj.get(0)%></th>
						<td><img alt=""
							src="<%=request.getContextPath()%>/img/<%=obj.get(1)%>"></td>
						<td><%=obj.get(1)%></td>
						<td><%=obj.get(2)%></td>
						<td><button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar" onclick="guardarId(<%=obj.get(3)%>)">ELIMINAR</button></td>
						<td><button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#modalActualizarImagen" onclick="editar(<%=obj.get(3)%>)">ACTUALIZAR</button></td>
						<td><a class="btn btn-primary" 
									role="button"
									onclick="editar(<%=obj.get(3)%>)" 
									>Editar
								</a></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="modalEliminar" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Eliminar
						Imagen</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">¿Desea eliminar la imagen?</div>
				<div class="modal-footer">
					<form id="eliminarForm"
						action="<%=request.getContextPath()%>/EliminarImagenServlet">
						<input name="id" type="hidden" id="idImagenEliminar">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Confirmar</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal para actualizar articulo-->
	<div class="modal fade" id="modalActualizarImagen" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form id="eliminarForm"
				action="<%=request.getContextPath()%>/ActualizarServlet"
				method="POST">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Actualizar
							Imagen</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="mb-3">
							<label for="id" class="form-label">ID</label>
						
							<input name="id" id="idImagen" type="hidden"> <span
								id="id"></span>
						</div>
						<div class="mb-3">
							<label for="url" class="form-label">URL</label> <input
								type="text" name="url" class="form-control" id="url">
						</div>
						<div class="mb-3">
							<label for="descripcion" class="form-label">DESCRIPCION</label> 
							<input
								type="text" name="descripcion" class="form-control" id="descripcion"
								aria-describedby="emailHelp">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script></body>
</body>
</html>