<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="container-login100">
			<div class="wrap-login100">
					<form class="form-horizontal" name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
				<div class="form-group">
				<div class="col-xs-3">
					<h2>Login Information</h2>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-3">
			      <label for="username">Username:</label>
			      <input type="text" class="form-control" name="username">
			      </div>
			    </div>
			    <div class="form-group">
			    <div class="col-xs-3">
			      <label for="password">Password:</label>
			      <input type="password" class="form-control" name="password">
			      </div>
			    </div>
			    <div class="form-group">
			    <div class="col-xs-3">
			    	<input name="submit" type="submit" value="Login" class="btn btn-default"/>
			    	<h4>${message }</h4>
			    	</div>
			    </div>
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	

</body>
</html>