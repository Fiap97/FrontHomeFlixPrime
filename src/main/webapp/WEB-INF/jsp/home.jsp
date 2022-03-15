<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Flix Prime</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<h1>Busqueda de peliculas</h1>
		<form:form action="/buscar" method="GET" modelAttribute="datos">
			<div class="form-group row col-12">
				<div class="form-group row col-6">
			      	 <p class="text-muted">Categoria  </p>
			      	 <br>
			     	 <select name="id_categoria" class="form-control">
			     	 	<c:forEach items="${categorias}" var="categoria">
			     	 		<option class="col-6" value="${categoria.category_id}"><c:out value="${categoria.name}"></c:out></option>
			     	 	</c:forEach>
					 </select>
				 </div>
				<div class="form-group row col-6">
			      	 <p class="text-muted">Titulo  </p>
			      	 <br>
			     	<input type="text" class="form-control" id="titulo" name="palabra">
				 </div>
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Buscar</button>
				  </div>
			  </div>		  
		</form:form>
		<div class="container">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">Categoria</th>
						<th scope="col">Id Film</th>
						<th scope="col">Titulo</th>
						<th scope="col">Duracion</th>
						<th scope="col">Rating</th>
						<th scope="col">Precio</th>
						<th scope="col">Duracion Arriendo</th>
						<th scope="col">Ver</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="fc"  items="${filmCategorys}">
								<tr>
									<td>${categoria.name}</td>
									<td>${fc.film.film_id}</td>
									<td>${fc.film.title}</td>
									<td>${fc.film.length}</td>
									<td>${fc.film.rating}</td>
									<td>${fc.film.replacement_cost}</td>
									<td>${fc.film.rental_duration}</td>
									<td><button type="button" class="btn btn-primary">Ver</button></td>
								</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	
</body>
</html>