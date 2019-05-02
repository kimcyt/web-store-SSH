<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="header_top row">
		<div class="col-md-5 offset-md-7">
			<!-- check if user already login -->
			<c:if test="${empty currentUser }">
				<a href="${pageContext.request.contextPath}/">Login</a>
				<a href="${pageContext.request.contextPath}/signup">Sign up</a>
			</c:if>
			<c:if test="${!empty currentUser }">
				Welcome! <a href=""> <b>${currentUser.username}</b></a>
				<a href="${pageContext.request.contextPath}/logout"> Log Out</a>
			</c:if>
			<a href="">Shopping Cart</a>
		</div>
	</div>
	<div class="header_mid row">
		<div id="icon" class="col-md-4">
			<img src="${pageContext.request.contextPath}/img/logo.png">
		</div>
		<div class="center col-md-6">
			<div class="input-group mb-3 search_box">
				<input type="text" class="form-control" placeholder="Enter keywords"
					aria-label="Search" aria-describedby="search">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button" id="search">Search</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>