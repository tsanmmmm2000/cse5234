<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Entry Form</title>
<style>
	table {
	  border-collapse: collapse;
	}
	th, td {
	  padding: 15px;
	  text-align: left;  
	  border-bottom: 1px solid #ddd;
	}
	tr:nth-child(even) {
	  background-color: #f2f2f2
	}
</style>
</head>
<body>
	<form:form modelAttribute="payment" method="post" action="submitPayment">
	    <table>
			<tr>
				<th>Title</th>
				<th>Value</th>
			</tr>		    
			<tr>
				<td>Credit Card Number</td>
				<td><form:input path="creditCardNumber" /></td>				
			</tr>
			<tr>
				<td>Expiration Date</td>
				<td><form:input path="expirationDate" /></td>				
			</tr>
			<tr>
				<td>CVV Code</td>
				<td><form:input path="cvvCode" /></td>				
			</tr>			
			<tr>
				<td>Card Holder Name</td>
				<td><form:input path="cardHolderName" /></td>				
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Pay"></td>
			</tr>	
	    </table>
	</form:form>
</body>
</html>