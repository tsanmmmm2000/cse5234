<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Entry Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">Order</div>
	<form:form modelAttribute="order" method="post" action="purchase/submitItems">
	    <table class="tableContainer">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>				
			</tr>	    
			<c:forEach items="${order.items}" var="item" varStatus="loop">
				<tr>
					<td class="left-col">
						<c:out value="${item.name}"></c:out>
						<form:hidden path="items[${loop.index}].name" value="${item.name}"/>					
					</td>				
					<td class="center-col">
						<c:out value="$${item.price}"></c:out>
						<form:hidden path="items[${loop.index}].price" value="${item.price}"/>					
					</td>
					<td class="center-col"><form:input path="items[${loop.index}].quantity" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><input type="submit" value="Purchase"></td>
		   	</tr>
	    </table>
	</form:form>
<jsp:include page="Footer.jsp"/>	
</body>
</html>