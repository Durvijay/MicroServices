<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Find Customer</title>
</head>
<body>
<jsp:include page="views/Menu.jsp"></jsp:include> 

	
	
	
	<h1>Find Customer By CustomerID</h1>
	<form method="GET" action="${contextPath}/customer/findCustomerDetails" id="search-form_3">
		<input type="text" id="custId" name="custId" /> 
		<input type="submit" value="Search" />
	</form>
	<jsp:include page="views/viewUser.jsp"></jsp:include> 
</body>
</html>