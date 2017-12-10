<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="views/Menu.jsp"></jsp:include>
	<div>
		<div>
			<label>Select a Customer :</label> <select name="customer">
				<c:forEach items="${customers}" var="customer">
					<option value="${customer.customerId}">
						<c:out value="${customer.customerName}" /></option>
				</c:forEach>
			</select>


			<%-- <select name="product">
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">
					<c:out value="${product.name}"/></option>
				</c:forEach>
			</select> --%>

		</div>
		<div>
			<form method="get">
				<label for="name">Search Products :</label> 
				<input id="txtSearchProductId" name="name" placeholder="Search the product" onchange="getProducts(document.getElementById('txtSearchProductId').value)" />
				<button class="btnSearch" onclick="getProducts()">Search</button>
			</form>

			<table id="resultTable">
				<thead>
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Description</th>
						<!-- <th><button name="Add" id="addProduct">Add</button></th> -->
					</tr>
				</thead>
				<tbody></tbody>
			</table>
			<ul id="dynamic-list"></ul>

			<input type="text" id="item" />
			<button onclick="addItem()">add item</button>
			<button onclick="removeItem()">remove item</button>
		</div>

	</div>
	<script src="/resources/js/script.js"></script>
	<script src="/resources/js/jquery-3.2.1.min.js"></script>
</body>
</html>