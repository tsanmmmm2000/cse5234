<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">Contact Us</div>
		<div class="wrapper">
		<div>Phone: <span class="explanation">123-456-7890</span></div>
		<div>Email: <span class="explanation">service@mygolf.com</span></div>
		<div>Address: <span class="explanation">281 W. Lane Ave., Columbus, OH 43210</span></div>
	</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>