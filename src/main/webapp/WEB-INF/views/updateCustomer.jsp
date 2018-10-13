<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error{
    color: red;
}
</style>
<title>Update Customer</title>
</head>
<body>
	<div class="container">
		<form:form 
					class="form-horizontal" action="./saveCustomer" modelAttribute="customer" method="POST">
					<div class="form-group">
					<div class="col-xs-4">
					<h3>Update Customer Information</h3>
					</div>
					</div>
					<table><tr><td>
					<label for="name">Name</label></td>
					<div class="form-group">
					<div class="col-xs-3">
					<td><form:input type="text" path="name" maxlength="255"/></td>
					<td><form:errors path="name" cssClass="error"></form:errors></td>
					</div>
					</div></tr>
					<tr><td><label for="phone">Phone Number</label></td>
					<div class="form-group">
					<div class="col-xs-3">
						<td><form:input type="text" path="phone" maxlength="15"/></td>
						<td><form:errors path="phone" cssClass="error"/></td>
					</div>
					</div>
					</tr>
					<tr><td><label for="email">Email</label></td>
					<div class="form-group">
					<div class="col-xs-3">
						<td><form:input type="text" path="email" maxlength="255"/></td>
						<td><form:errors path="email" cssClass="error"/></td>
					</div>
					</div>
					</tr>
					<tr><td><label for="gender">Gender</label></td>
					<td>
						Male <form:radiobutton path="gender" value="true" /> 
						Female <form:radiobutton path="gender" value="false"/>
						<form:errors path="gender" cssClass="error"/>
					</td>
					</tr>
					<tr><td><label for="dob">Date of Birth</label></td>
					<div class="form-group">
					<div class="col-xs-3">
						<td><form:input type="date" path="dob" class="datepicker" data-date-format="mm/dd/yyyy"/></td>
						<td><form:errors path="dob" class ="error"/></td>
					</div>
					</div>
					</tr>
					<tr><td><label for="dob">Address</label></td>
					<div class="form-group">
					<div class="col-xs-3">
						<td><form:input type="text" path="address"/></td>
						<td><form:errors path="address" cssClass="error"/></td>
					</div>
					</div>
					</tr>
					<tr><td><label for="dob">Title</label></td>
					<div class="form-group">
					<div class="col-xs-3">
						<td><form:select path="title">
						<form:options items="${titles }"/>
						</form:select></td>
					</div>
					</div>
					</tr>
					</table>
					<div class="container-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="btn btn-success" type="submit" name="search">
								Save
							</button>
						</div>
					</div>
				<form:hidden path=""/>
				</form:form>
				<h4>${message }</h4>
	</div>
</body>
</html>