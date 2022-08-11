<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class = "container">
		<div>
			<h1>Create Ninja</h1>
		</div>
		<div>
			<form:form action = "/add/ninja" method="post" modelAttribute="ninja">
				<div>
					<form:label path = "dojo">Dojo</form:label>
					<form:select path = "dojo">
						<c:forEach var="dojo" items="${dojoList}">
				            <!--- Each option VALUE is the id of the person --->
				            <form:option value="${dojo.id}" path="dojo">
				            <!--- This is what shows to the user as the option --->
				                <c:out value="${dojo.name}"/>
				            </form:option>
				        </c:forEach>
					</form:select>
					<div class="form-text">
						<form:errors class="errors" path = "dojo"/>
					</div>
				</div>
				<div>
					<form:label path = "firstName">First Name</form:label>
					<form:input path = "firstName" type= "text"/>
					<div class="form-text">
						<form:errors class="errors" path = "firstName"/>
					</div>
				</div>
				<div>
					<form:label path = "lastName">Last Name</form:label>
					<form:input path = "lastName" type= "text"/>
					<div class="form-text">
						<form:errors class="errors" path = "lastName"/>
					</div>
				</div>
				<div>
					<form:label path = "age">Age</form:label>
					<form:input path = "age" type= "number"/>
					<div class="form-text">
						<form:errors class="errors" path = "age"/>
					</div>
				</div>
				<button type= "submit">Create ninja</button>
			</form:form>
		</div>
	</div>
</body>
</html>