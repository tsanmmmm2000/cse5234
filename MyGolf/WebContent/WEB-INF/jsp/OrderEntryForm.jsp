<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Entry Form</title>
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
	<form:form modelAttribute="order" method="post" action="purchase/submitItems">
	    <table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>				
			</tr>	    
			<c:forEach items="${order.items}" var="item" varStatus="loop">
				<tr>
					<td>
						<c:out value="${item.name}"></c:out>
						<form:hidden path="items[${loop.index}].name" value="${item.name}"/>					
					</td>				
					<td>
						<c:out value="$${item.price}"></c:out>
						<form:hidden path="items[${loop.index}].price" value="${item.price}"/>					
					</td>
					<td><form:input path="items[${loop.index}].quantity" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><input type="submit" value="Purchase"></td>
		   	</tr>
	    </table>
	</form:form>
</body>
</html>