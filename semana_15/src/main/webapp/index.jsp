<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>inicio</title>
  </head>
  <body>
    <header><h1>REGISTRO</h1></header>
    <main>
         <form class="row g-3 needs-validation" action="<%=request.getContextPath()%>/RegistroServlet" method="post">
  <div class="col-md-4">
    <label class="form-label">Nombre</label>
    <input type="text" name="nombre" class="form-control"  value="Ingrese nombre" required>
    <div class="valid-feedback">

    </div>
  </div>
  <div class="col-md-4">
    <label class="form-label">Apellido</label>
    <input type="text" name="apellido" class="form-control" id="validationCustom02" value="Ej:Diaz" required>
    <div class="valid-feedback">
  
    </div>
  </div>
  <div class="col-md-4">
    <label  class="form-label">Documento de identidad</label>
    <div class="input-group has-validation">
      <span class="input-group-text" id="inputGroupPrepend">identidad</span>
      <input type="number" name="documento" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
      <div class="invalid-feedback">
      </div>
    </div>
  </div>
  
  <div class="col-md-6">
    <label class="form-label" Style=>Fecha de nacimiento</label>
    <input type="date" name="fechaNacimiento" class="form-control">
    
  </div>
  <div class="col-md-3">
    <label class="form-label">Ocupacion</label>
    <select class="form-select" name="ocupacion" id="validationCustom04" required>
      <option selected disabled value="">Selecciona</option>
      <option>vendedor</option>
      <option>trabajador independiente</option>
      <option>abogado</option>
      <option>ingeniero</option>
      <option>medico</option>
      <option>matematico</option>
      <option>administrador</option>
      <option>carpintero</option>
      <option>otro</option>
    </select>
  </div>
  <div class="col-md-3">
    <label for="validationCustom05" class="form-label">Edad</label>
    <input type="number" name="edad"class="form-control" id="validationCustom05" required>
  </div>
  <div class="col-12">
    <button class="btn btn-primary" type="submit">Enviar</button>
  </div>
</form>
    </main>
    
    <br>
    
    <a class="btn btn-primary" href="<%=request.getContextPath()%>/DatosServlet" role="button">Ver todos los registros</a>
    
    
    
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
</html>