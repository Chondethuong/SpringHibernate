<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>Update Customer Information</h3><br>
		<form:form 
					class="login100-form validate-form" action="./saveCustomer" modelAttribute="customer" method="POST">
					<table>
					<tr><td>Name</td><td>
						<form:hidden path="id"/>
						<form:input class="input100" type="text" path="name"/>
						<form:errors path="name" class="control-label" />
					</td>
					</tr>
					<tr>
					<td>Phone</td>
					<td>
					<div class="wrap-input100 validate-input">
						<form:input class="input100" type="text" path="phone"/>
						<form:errors path="phone"/>
					</div>
					</td>
					</tr>
					<tr>
					<td>Email</td>
					<td>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<form:input class="input100" type="text" path="email"/>
						<form:errors path="email"/>
					</div>
					</td>
					</tr>
					<tr>
					<td>Gender</td>
					<td>
						Male <form:radiobutton path="gender" value="true" /> 
						Female <form:radiobutton path="gender" value="false"/> 
						<form:errors path="gender"/>
					</td>
					</tr>
					<tr>
					<td>Date of Birth</td>
					<td>
					<div class="wrap-input100 validate-input">
						<form:input type="date" path="dob"/>
						<form:errors path="dob"/>
					</div>
					 </td>
					 </tr>
					 <tr>
					 <td>
					</td></tr>
					<tr>
					<td>Address</td>
					<td><form:input class="input100" type ="text" path="address"/>
					<form:errors path="address"/>
					</td>
					</tr>
					<tr>
					<td>Titile</td>
					<td>
					<form:select path="title">
						<form:options items="${titles }"/>
					</form:select>
					</td>
					</tr>
					</table>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" name="save">
								Save
							</button>
						</div>
					</div>
				</form:form>
				<h4>${message }</h4>
	</div>
</body>
</html>