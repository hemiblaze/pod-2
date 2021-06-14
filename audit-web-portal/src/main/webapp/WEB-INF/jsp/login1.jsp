<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<!-- Modal Content -->
	<form:form action="/home" modelAttribute="user" method="post">
		<div class="imgcontainer">
			<img src="img_avatar2.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="uname"><b>Username</b></label>
			<form:input path="userId" class="input" placeholder="enter the user id" required="required" />
			<label for="psw"><b>Password</b></label>
			<form:input type="password" path="password" class="input" placeholder="enter the password" required="required"/>

			<button type="submit">Login</button>

		</div>
	</form:form>

</body>
</html>