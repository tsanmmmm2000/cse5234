<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" />
</head>
<body class="body">
<jsp:include page="Header.jsp"/>
	<div class="prodheading">About Us</div>
	<div class="wrapper">
		<h3>Tsan-Ming Lu</h3>
		<h3 class="explanation">Sales Representative</h3>			
		<img class="circle right-img" src="${pageContext.request.contextPath}/images/superman.png">
		<div>Responsible for selling products to businesses,</div>
		<div>organizations and government agencies.</div>
	</div>
	<hr>
	<div class="wrapper">
		<h3>Nam Nguyen</h3>
		<h3 class="explanation">Software Engineer</h3>			
		<img class="circle right-img" src="${pageContext.request.contextPath}/images/temp.png">
		<div>Responsible for designing, writing and testing real software.</div>
	</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>