<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp" />
	<div class="prodheading">We are My Golf</div>
	<div class="wrapper">
		<h3>Shop the best brands in golf</h3>
		<div>My Golf is proud to bring you today's most popular golf brands.</div>
		<div>From clubs to apparel, we strive to feature the most extensive assortment of quality golf products.</div>
	</div>
	<hr>
	<div class="wrapper">
		<h3>Featured Brands</h3>
		<div>
			<img src="${pageContext.request.contextPath}/images/adidas.png">
			<img src="${pageContext.request.contextPath}/images/nike.png">
			<img src="${pageContext.request.contextPath}/images/puma.png">
			<img src="${pageContext.request.contextPath}/images/under_armour.png">
		</div>
	</div>	
<jsp:include page="Footer.jsp" />
</body>
</html>