<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-8">
				<form:form action="/lenguajes/new" method="POST"
					modelAttribute="editLenguaje">
					<form:errors class="text-danger" path="name" />
					<form:errors class="text-danger" path="nameCreator" />
					<form:errors class="text-danger" path="version" />
					<div class="mb-3">
						<form:label path="name" for="name" class="form-label">Nombre</form:label>
						<form:input path="name" type="text" class="form-control" id="name"
							name="name" value="${lang.name}" />

						<form:label path="nameCreator" for="creator" class="form-label">Creador</form:label>
						<form:input path="nameCreator" type="text" class="form-control"
							id="creator" name="creator" value="${lang.creator}" />

						<form:label path="version" for="currentVersion"
							class="form-label">Version</form:label>
						<form:input path="version" type="text" class="form-control"
							id="currentVersion" name="currentVersion"
							value="${lang.currentVersion}" />
					</div>
					<div class="row mb-3">
						<div class="col text-center">
							<button type="submit" class="btn btn-lg btn-primary">Guardar</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>