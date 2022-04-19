<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>datos</title>
</head>
<body>
    <main>
    <a class="btn btn-primary" href="<%=request.getContextPath()%>/index.jsp" role="button">IR A INICIO</a>
    <table class="table">
  <thead>
    <tr>
      <th scope="col">DOCUMENTO</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">APELLIDO</th>
      <th scope="col">EDAD</th>
      <th scope="col">FECHA DE NACIMIENTO</th>
      <th scope="col">OCUPACION</th>
    </tr>
  </thead>
  <tbody>
  <%
  Object registros = request.getAttribute("MAPA");
  Map<Long,List<Object>> map =(Map<Long,List<Object>>)registros;
  
 %>
  <% 
   for (Map.Entry<Long,List<Object>> entry : map.entrySet()){	    
  %>
    <tr>
      <td><%=entry.getKey()%></td>
      <td><%=entry.getValue().get(0)%></td>
      <td><%=entry.getValue().get(1) %></td>
      <td><%=entry.getValue().get(2) %></td>
      <td><%=entry.getValue().get(3) %></td>
      <td><%=entry.getValue().get(4) %></td>
    </tr>
   <% }
         %> 
         
  </tbody>
</table>
<a class="btn btn-primary" href="<%=request.getContextPath()%>/DatosServlet" role="button">Actualizar</a>
    </main>
</body>
</html>