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
		<h3>Create Customer Information</h3><br>
		<form:form 
					class="login100-form validate-form" action="./saveCustomer" modelAttribute="customer" method="POST">
					<table>
					<tr><td>Name</td><td>
						<form:input type="text" path="name" maxlength="255"/>
						<form:errors path="name" cssClass="error"></form:errors>
					</td>
					</tr>
					<tr>
					<td>Phone</td>
					<td>
					
						<form:input type="text" path="phone" maxlength="15"/>
						<form:errors path="phone" cssClass="error"/>
					
					</td>
					</tr>
					<tr>
					<td>Email</td>
					<td>
						<form:input type="text" path="email" maxlength="255"/>
						<form:errors path="email" cssClass="error"/>
					</td>
					</tr>
					<tr>
					<td>Gender</td>
					<td>
					
						Male <form:radiobutton path="gender" value="true" /> 
						Female <form:radiobutton path="gender" value="false"/>
						<form:errors path="gender" cssClass="error"/>
						<!-- Male <input class="input100" type="radio" name="gender" value="true" checked="checked">
						Female <input class="input100" type="radio" name="gender" value="false"> -->
					
					</td>
					</tr>
					<tr>
					<td>Date of Birth</td>
					<td>
					
						<form:input type="date" path="dob"/>
						<form:errors path="dob"/>
					 </td>
					 </tr>
					 <tr>
					 <td>
					</td></tr>
					<tr>
					<td>Address</td>
					<td><form:input type="text" path="address"/>
					<form:errors path="address" cssClass="error"/>
					</td>
					</tr>
					<tr>
					<td>Titile</td>
					<td>
					<form:select path="title">
						<form:options items="${titles }"/>
					</form:select>
					<%-- <select name="title">
						<c:forEach var="title" items="${titles }">
							<option value="${title }">${title}</option>
						</c:forEach>
					</select> --%>
					</td>
					</tr>
					</table>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" name="search">
								Save
							</button>
						</div>
					</div>
				</form:form>
				<h4>${message }</h4>
	</div>
</body>
</html>