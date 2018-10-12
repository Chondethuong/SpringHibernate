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
		<h3>Search</h3><br>
		<form:form action="./search" modelAttribute="customerFormData" method="POST" name="search">
					<table>
					<tr><td>Name</td><td>
						<form:input class="input100" type="text" path="name" />
						<form:errors cssClass="error" path="name"></form:errors>
					</td>
					<td>Phone</td>
					<td>
					<div class="wrap-input100 validate-input">
						<form:input class="input100" type="text" path="phone"/>
						<form:errors path="phone" cssClass="error"></form:errors>
					</div>
					</td>
					</tr>
					<tr>
					<td>Email</td>
					<td>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<form:input class="input100" type="text" path="email"/>
						<form:errors path="email" cssClass="error"></form:errors>
					</div>
					</td>
					<td>Gender</td>
					<td>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<!-- Male <input class="input100" type="radio" name="gender" value="true" checked="checked">
						Female <input class="input100" type="radio" name="gender" value="false"> -->
						Male <form:radiobutton path="gender" value="true" />
						Female <form:radiobutton path="gender" value="false"/>
					</div>
					</td>
					</tr>
					<tr>
					<td>Date of Birth</td>
					<td>
					<div class="wrap-input100 validate-input">
						<form:input type="date" path="dob"/>
					</div>
					 </td>
					 <td>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" name="search">
								Search
							</button>
						</div>
					</div>
					</td></tr>
					</table>
				</form:form>
				<button class="login100-form-btn" name="search" onclick="clearSearchCriteria();">
					Clear
				</button>
						
	</div>
	<div>
	<h3>Command</h3>
	<table><tr><td>
		<form:form action="./create">
			<button class="login100-form-btn" type="submit" name="create">
				New
			</button>
		</form:form>
		</td><td>
		<form:form action="./export">
			<button class="login100-form-btn" type="submit" name="export">
				Export
			</button>
		</form:form>
		</td><td>
		<button class="login100-form-btn" type="submit" id="update" onclick="update();">
			Update
		</button>
		</td>
		</tr>
	</table>
	</div>
	<br>
	<br>
	<div>
		<table border="1" style="border-collapse: collapse">
			<thead><tr><th></th><th>Name</th><th>Date of Birth</th><th>Phone</th><th>Email</th></tr></thead>
			<c:forEach var="customer" items="${customers}">
			<tr><td><input type="checkbox" name="idnumber" value="${customer.id }"> </td><td>${customer.name}</td><td> ${customer.dob}</td> <td>${customer.phone }</td><td>${customer.email }</td></tr>
			</c:forEach>
		</table>
		<c:forEach begin="1" end="${pages }" varStatus="index">
			<input type="button" value = ${index.index } onclick="paging(this);">
		</c:forEach>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
var selectedPage;
function update(){
	var checkboxes = document.getElementsByName("idnumber");
	var checkboxesChecked = [];
	for (var i=0; i<checkboxes.length; i++) {
	     if (checkboxes[i].checked) {
	    	 checkboxesChecked.push(checkboxes[i]);
	     }
	 }
	if (checkboxesChecked.length > 1){
		alert("Select only one customer");
	}else if (checkboxesChecked.length == 0){
		alert("Please select one customer");
	}else{
		var id = checkboxesChecked[0].value;
		window.location.href = "${pageContext.request.contextPath}/updateCustomer?id=" + id;
		/* var id = checkboxes[0].value;
		alert(id);
		$.ajax({
			type: "GET",
			contentType: "application/json; charset=utf-8",
			url: "./updateCustomer",
			data : {"id": id},
			dataType: 'json'
		}); */
		
	}
}
function paging(page){
		selectedPage = page.value;
		window.location.href = "${pageContext.request.contextPath}/customers?page=" + selectedPage;
}
</script>
</html>