<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping Entry Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">Shipping</div>
	<form:form modelAttribute="shipping" method="post" action="submitShipping">
	    <table class="tableContainer">
			<tr>
				<th>Title</th>
				<th>Value</th>
			</tr>	    
			<tr>
				<td class="left-col">Name</td>
				<td class="center-col"><form:input path="name" /></td>				
			</tr>
			<tr>
				<td class="left-col">Address Line 1</td>
				<td class="center-col"><form:input path="addressLine1" /></td>				
			</tr>
			<tr>
				<td class="left-col">Address Line 2</td>
				<td class="center-col"><form:input path="addressLine2" /></td>				
			</tr>			
			<tr>
				<td class="left-col">City</td>
				<td class="center-col"><form:input path="city" /></td>				
			</tr>
			<tr>
				<td class="left-col">State</td>
				<td class="center-col"><form:input path="state" /></td>				
			</tr>
			<tr>
				<td class="left-col">ZIP</td>
				<td class="center-col"><form:input path="zip" /></td>				
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Ship"></td>
			</tr>	
	    </table>
	</form:form>
<jsp:include page="Footer.jsp"/>	
</body>
</html>