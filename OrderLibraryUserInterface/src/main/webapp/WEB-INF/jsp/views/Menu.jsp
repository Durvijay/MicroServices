<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<ul>
		<li><a href="${contextPath}/customer/home">Home</a></li>
		<li><a href="${contextPath}/customer/displayCreateCustomer">Create Customer</a></li>
		<li><a href="${contextPath}/customer/displayAllCustomers">ALL Customers</a></li>
		<li><a href="${contextPath}/customer/GetPaymentView">Find Payment</a></li>
		<li><a href="${contextPath}/customer/findCustomerView">Find Customer</a></li>
		<li><a href="${contextPath}/customer/DeleteCustomer">Delete Customer</a></li>
		<li><a href="${contextPath}/customer/UpdateCustomer">Update Customer</a></li>
		<li><a href="${contextPath}/customer/AddPayment">Add Payment</a></li>
		<li><a href="${contextPath}/customer/BuyProducts">Buy Products</a></li>
	</ul>
</body>
</html>