<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Entry Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">Payment</div>
	<form:form modelAttribute="payment" method="post" action="submitPayment">
	    <table class="tableContainer">
			<tr>
				<th>Title</th>
				<th>Value</th>
			</tr>		    
			<tr>
				<td class="left-col">Credit Card Number</td>
				<td class="center-col"><form:input path="creditCardNumber" /></td>				
			</tr>
			<tr>
				<td class="left-col">Expiration Date</td>
				<td class="center-col"><form:input path="expirationDate" /></td>				
			</tr>
			<tr>
				<td class="left-col">CVV Code</td>
				<td class="center-col"><form:input path="cvvCode" /></td>				
			</tr>			
			<tr>
				<td class="left-col">Card Holder Name</td>
				<td class="center-col"><form:input path="cardHolderName" /></td>				
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Pay"></td>
			</tr>	
	    </table>
	</form:form>
<jsp:include page="Footer.jsp"/>	
</body>
</html>