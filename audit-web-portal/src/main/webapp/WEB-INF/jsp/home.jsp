<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Project Details - Audit Management System</title>
<style>
body {
	background: orange;
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

form {
	background: white;
}

h1 {
	color: #FFF;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">

		<h1 class="m-3 text-center display-4" style="color: black">
			<strong>PROJECT DETAILS</strong>
		</h1>

		<form:form action="/AuditCheckListQuestions"
			modelAttribute="projectDetails" method="post"
			class="px-5 py-4 border rounded">

			<div class="form-group">
				<form:label path="projectName">Project Name</form:label>
				<form:input path="projectName" required="required"
					class="form-control" id="ProjectName" />

			</div>
			<div class="form-group">
				<form:label path="managerName">Project Manager Name</form:label>
				<form:input path="managerName" required="required"
					class="form-control" id="ProjectManagerName" />
			</div>
			<div class="form-group">
				<form:label path="ownerName">Application Owner</form:label>
				<form:input path="ownerName" required="required"
					class="form-control" id="ApplicationOwnerName" />
			</div>

			<div class="form-group">
				<label for="AuditType">Audit Type</label>
				<form:form modelAttribute="auditType">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<form:radiobutton path="auditType" required="required"
									id="internal" value="Internal" name="audittype"
									aria-label="Radio button for following text input" />
							</div>
						</div>
						<label for="Internal" class="form-control"> Internal</label>

						<div class="input-group-prepend">
							<div class="input-group-text">
								<form:radiobutton path="auditType" id="sox" value="SOX"
									name="audittype"
									aria-label="Radio button for following text input" />
							</div>
						</div>
						<label for="SOX" class="form-control"> SOX</label>
					</div>
					<input type="submit" class="btn btn-success btn-block mt-3"
						value="Submit">
				</form:form>
			</div>





		</form:form>

	</div>




	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>



</body>
</html>




