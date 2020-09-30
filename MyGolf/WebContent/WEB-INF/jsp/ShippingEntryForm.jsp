<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping Entry Form</title>
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
	<form:form modelAttribute="shipping" method="post" action="submitShipping">
	    <table>
			<tr>
				<th>Title</th>
				<th>Value</th>
			</tr>	    
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>				
			</tr>
			<tr>
				<td>Address Line 1</td>
				<td><form:input path="addressLine1" /></td>				
			</tr>
			<tr>
				<td>Address Line 2</td>
				<td><form:input path="addressLine2" /></td>				
			</tr>			
			<tr>
				<td>City</td>
				<td><form:input path="city" /></td>				
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" /></td>				
			</tr>
			<tr>
				<td>ZIP</td>
				<td><form:input path="zip" /></td>				
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Ship"></td>
			</tr>	
	    </table>
	</form:form>
</body>
</html>