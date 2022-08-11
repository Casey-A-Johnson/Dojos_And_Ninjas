<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class = "container">
		<div>
			<h1>List of Dojos</h1>
		</div>
		<div>
			<c:forEach var= "eachDojo" items= "${dojoList }" >
				<h4><a href="/dojos/${eachDojo.id}">${eachDojo.name }</a></h4>
			</c:forEach>
		</div>
		<div>
			<h1>Create a Dojo</h1>
		</div>
		<div>
			<form:form action = "/add/dojo" method="post" modelAttribute="dojo">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="text"/>
				<div class="form-text">
					<form:errors class="errors" path = "name"/>
				</div>
				<button type= "submit">Create</button>
			</form:form>
		</div>
		<div>
			<a href="/add/ninja">Create a ninja</a>
		</div>
	</div>
</body>
</html>