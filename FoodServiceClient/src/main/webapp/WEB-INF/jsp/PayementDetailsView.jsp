<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Design search Button</title>
</head>
<body>
	<jsp:include page="views/Menu.jsp"></jsp:include> 
	<br><br>
	<form method="GET" action="${contextPath}/customer/findPaymentsDetails" id="search-form_3">
		<input type="text" name="custId" class="search_3" /> 
		<input type="submit" class="submit_3" value="Search" />
	</form>
	
	<jsp:include page="views/viewPaymentDetails.jsp"></jsp:include>
</body>
</html>