<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Add Item</h2>
	<!-- enctype: the encryption type when the form is sent to the server, 
	the default type can only get the name but the content of the uploaded file
	multipart divides each input in the body, file input has its own structure
	cannot use getParameter() to get input data anymore -->
	<!-- "${pageContext.request.contextPath}/manageGoods?action=add" 
	 
	<c:if test="${empty allCategories}">
			<select name="category">
				<option value="${category.NO }">${category.name }</option>
			</select>
	</c:if>
	-->
	<form:form modelAttribute="good" enctype="multipart/form-data" action="${pageContext.request.contextPath}/good" method="POST">
		<span>Item name: </span><form:input type="text" path="name" required="true" /><br>
		<span>Picture: </span><input type="file" name="image" /><br>
		<span>Price: </span><form:input type="text" path="price" required="true"/><br>
		<span>Category: </span> 
		<c:if test="${!empty allCategories}">
			<form:select path="category">
				<c:forEach items="${allCategories }" var="category">
					<option value="${category.NO }">${category.name }</option>
				</c:forEach>	
			</form:select>
		</c:if>
		
		<input type="submit" value="Add Item"> 
	</form:form>
	<p>${error}"</p>
	
	<c:if test="${empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1">Go Back</a>
	</c:if>
	<c:if test="${!empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1&category=${category}">Go Back</a>
	</c:if>

</body>
</html>