<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html  >
<html>
<head>
<!-- Loading Bootstrap -->
<link href="../../resources/css/vendor/bootstrap.min.css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link
	href="${pageContext.request.contextPath}/resources/css/flat-ui.css"
	rel="stylesheet">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="background: #1abc9c; height: 387px; width: 1241px">


	<form action="j_spring_security_check" method="POST">





		<font color="red"> <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
		</font>
		<div class="login-form"
			style="width: 550px;margin-left: 350px;margin-top: 150px;">
			<span>userName:Admin</span>
			<span>password:Admin</span>
			<div class="form-group">
				<input type="text" name="j_username"
					class="form-control login-field" value=""
					placeholder="Enter your username" id="login-name"
					style="width: 486px; height:27px;"> <label
					class="login-field-icon fui-user"
					style="position:relative;right:30px;" for="login-name"></label>
			</div>

			<div class="form-group">
				<input type="password" name="j_password"
					class="form-control login-field" value="" placeholder="Password"
					id="login-pass" style="width: 486px; height: 27px"> <label
					class="login-field-icon fui-lock"
					style="position:relative;right:30px;" for="login-pass"></label>
			</div>

			<input type="submit" class="btn btn-primary btn-lg btn-block"
				style="width: 515px" value="Log in" />

		</div>
	</form>
</body>
</html>