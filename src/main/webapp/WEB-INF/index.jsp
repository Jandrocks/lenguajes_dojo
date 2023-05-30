<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title herse</title>
</head>
<body>

<a href="/lenguaje/new">nuevo lenguaje</a>
		<h1>Bienvenido a los lenguajes</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Create</th>
				<th>Version</th>
				<th>Actions</th>			
			</tr>
		</thead>
		<tbody>		
			<c:forEach var="lenguaje" items="${lenguaje}">
				<tr>
					<td><a href="/lenguajes/${lenguaje.id}"><c:out 
								value="${lenguaje.name }"></c:out></a></td>
					<td> <c:out value="${lenguaje.nameCreator }"></c:out></td>
					<td><c:out value="${lenguaje.version }"></c:out></td>
					<td><a href="/lenguajes/delete/${lenguaje.id}">delete</a> <a
						   href="/lenguajes/edit/${lenguaje.id}">edit</a></td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>