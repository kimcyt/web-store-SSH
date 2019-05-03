<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/displayGood.css" rel="stylesheet">
<title>${good.name }</title>
</head>
<body>
	<div class="container">
		<div class="container">
			<%@ include file="header.jsp"%>
				<a href="${pageContext.request.contextPath}/goods/1/20/">Go Back</a>
				<br>
				<div class="title row">
					<h2>${good.name }</h2>
				</div>
				<br>
				<div class="row info">
					<div class="col-md-5">
						<img src="${pageContext.request.contextPath}/img/${good.category}/${good.gallery.get(0)}">
					</div>
					<div class="col-md-5 offset-md-2">
						<h4>Price: ${good.price }</h4>
						<a href=""><button>Purchase</button></a>
						<a href=""><button>Add To Cart</button></a>
					</div>
				</div>
				
				<br><br><br>
				
				<div class="row gallery">
					<div class="col-md-10 offset-md-1">
						<c:forEach items="${good.gallery}" var="pic">
							<img src="${pageContext.request.contextPath}/img/${pic}">
						</c:forEach>
					</div>
				</div>
				
			<br><br>
			<%@ include file="footer.jsp"%>

		</div>
	</div>
	

	
	
</body>
</html>