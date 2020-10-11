<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">View Order</div>
	<form:form method="post" action="confirmOrder">
	    <table class="tableContainer">
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
					<td class="left-col">
						<c:out value="${item.name}"></c:out>
					</td>
					<td class="center-col">
						<c:out value="$${item.price}"></c:out>
					</td>
					<td class="center-col">
						<c:out value="${item.quantity}"></c:out>
					</td>
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
				<td class="left-col">Credit Card Number</td>
				<td class="center-col" colspan="2"><c:out value="${payment.creditCardNumber}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">Expiration Date</td>
				<td class="center-col" colspan="2"><c:out value="${payment.expirationDate}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">CVV Code</td>
				<td class="center-col" colspan="2"><c:out value="${payment.cvvCode}"></c:out></td>
			</tr>			
			<tr>
				<td class="left-col">Card Holder Name</td>
				<td class="center-col" colspan="2"><c:out value="${payment.cardHolderName}"></c:out></td>
			</tr>		
			<tr>
				<th colspan="3" class="title">Shipping</th>
			</tr>
	    	<tr>
				<th>Title</th>
				<th colspan="2">Value</th>
	    	</tr>			
			<tr>
				<td class="left-col">Name</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.name}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">Address Line 1</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.addressLine1}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">Address Line 2</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.addressLine2}"></c:out></td>
			</tr>			
			<tr>
				<td class="left-col">City</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.city}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">State</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.state}"></c:out></td>
			</tr>
			<tr>
				<td class="left-col">ZIP</td>
				<td class="center-col" colspan="2"><c:out value="${shipping.zip}"></c:out></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Confirm"></td>				
		   	</tr>
	    </table>
	</form:form>
<jsp:include page="Footer.jsp"/>
</body>
</html>