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
		<form:form action="./search" modelAttribute="customerFormData" method="POST" id="search">
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
					 </tr>
					 <tr>
					 <td>
					 <form:hidden path="page"/>
					<div class="container-login100-form-btn">
							<button class="login100-form-btn" onclick="doSearch();">
								Search
							</button>
						</div>
					</td>
					<td>
					<input type="button" name="search" value="Clear" onclick="clearSearchCriteria();">
					</td>
					</tr>
					</table>
				<input type="hidden" value="${customerFormData.page }" id = "currentPage">
				</form:form>
						
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
		<td>
		<button class="login100-form-btn" type="submit" id="update" onclick="deleteCustomers();">
			Delete
		</button>
		</td>
		</tr>
	</table>
	</div>
	<br>
	<br>
	<div>
		<table border="1" style="border-collapse: collapse">
			<thead><tr><th></th><th>Name &#9660;</th><th>Date of Birth &#9660;</th><th>Phone &#9660;</th><th>Email &#9660;</th></tr></thead>
			<c:forEach var="customer" items="${customers}">
			<tr><td><input type="checkbox" name="idnumber" value="${customer.id }"> </td><td>${customer.name}</td><td> ${customer.dob}</td> <td>${customer.phone }</td><td>${customer.email }</td></tr>
			</c:forEach>
		</table>
		<button value="1" onclick="paging(this);" id="firstPage"><<</button>
		<button value="${customerFormData.page - 1}" onclick="paging(this);" id="prevPage"><</button>
		<c:forEach begin="1" end="${pages }" varStatus="index">
			<input type="button" value = ${index.index } <c:if test="${index.index == customerFormData.page}">disabled="disabled" </c:if> 
			onclick="paging(this);">
		</c:forEach>
		<input type="hidden" value="${pages }" id="maxPage">
		<button value="${customerFormData.page + 1 }" onclick="paging(this);" id="nextPage">></button>
		<button value="${pages }" onclick="paging(this);" id="lastPage">>></button>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	var maxPage = document.getElementById("maxPage").value; 
	var currPage = document.getElementById("currentPage").value;
    if (currPage == 1 || currPage == 0){
    	document.getElementById("firstPage").disabled = true;
    	document.getElementById("prevPage").disabled = true;
    }
    if (currPage == maxPage || maxPage == 0){
    	document.getElementById("lastPage").disabled = true;
    	document.getElementById("nextPage").disabled = true;
    }
 });
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
function deleteCustomers(){
	var checkboxes = document.getElementsByName("idnumber");
	var checkboxesChecked = [];
	var id = "";
	for (var i=0; i<checkboxes.length; i++) {
	     if (checkboxes[i].checked) {
	    	 checkboxesChecked.push(checkboxes[i]);
	     }
	 }
	if (checkboxesChecked.length == 0){
		alert("Please select customer to delete");
	}else{
		var result = confirm("Want to delete?");
		if (result){
			for (var i = 0; i< checkboxesChecked.length; i++){
				id += checkboxesChecked[i].value +",";	
			}
			window.location.href = "${pageContext.request.contextPath}/deleteCustomer?id=" + id;
		}
	}
}
function paging(page){
	var selectedPage;
	selectedPage = page.value;
	$("#page").val(selectedPage);
    $("#search").submit(); 
}
function clearSearchCriteria(){
	$(':input','#search')
	  .not(':button, :submit, :reset, :hidden')
	  .val('')
	  .removeAttr('selected');
}
function doSearch(){
	$("#page").val(1);
    $("#search").submit(); 
}
</script>
</html>