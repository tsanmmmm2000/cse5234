<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
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
	.title {
	  background-color: #4CAF50;
	  color: white;
	}
</style>	
</head>
<body>
	<h2>Thank you for your order!</h2>
    <table>
    	<tr>
    		<th colspan="3" class="title">Order</th>    		
    	</tr>
    	<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>    		
    	</tr>
		<c:forEach items="${order.items}" var="item">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td>
				<td><c:out value="${item.quantity}"></c:out></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="3" class="title">Payment</th>				
		</tr>
    	<tr>
			<th>Title</th>
			<th colspan="2">Value</th>
    	</tr>	
		<tr>
			<td>Credit Card Number</td>
			<td colspan="2"><c:out value="${payment.creditCardNumber}"></c:out></td>
		</tr>
		<tr>
			<td>Expiration Date</td>
			<td colspan="2"><c:out value="${payment.expirationDate}"></c:out></td>
		</tr>
		<tr>
			<td>CVV Code</td>
			<td colspan="2"><c:out value="${payment.cvvCode}"></c:out></td>
		</tr>			
		<tr>
			<td>Card Holder Name</td>
			<td colspan="2"><c:out value="${payment.cardHolderName}"></c:out></td>
		</tr>		
		<tr>
			<th colspan="3" class="title">Shipping</th>
		</tr>
    	<tr>
			<th>Title</th>
			<th colspan="2">Value</th>
    	</tr>
		<tr>
			<td>Name</td>
			<td colspan="2"><c:out value="${shipping.name}"></c:out></td>
		</tr>
		<tr>
			<td>Address Line 1</td>
			<td colspan="2"><c:out value="${shipping.addressLine1}"></c:out></td>
		</tr>
		<tr>
			<td>Address Line 2</td>
			<td colspan="2"><c:out value="${shipping.addressLine2}"></c:out></td>
		</tr>			
		<tr>
			<td>City</td>
			<td colspan="2"><c:out value="${shipping.city}"></c:out></td>
		</tr>
		<tr>
			<td>State</td>
			<td colspan="2"><c:out value="${shipping.state}"></c:out></td>
		</tr>
		<tr>
			<td>ZIP</td>
			<td colspan="2"><c:out value="${shipping.zip}"></c:out></td>				
		</tr>
    </table>
</body>
</html>