<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html lang="en">

<body>
	<div class="container">
		<div class="container-login100">
			<div class="wrap-login100">
					<form class="form-horizontal" name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
				<table>
					<tr>
						<td>User:</td>
						<td><input type='text' name='username'></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit" value="login" /></td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<h4>${message }</h4>
			</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	

</body>
</html>