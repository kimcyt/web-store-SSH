<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Item</title>
<style type="text/css">
img{
	height: 200px;
	width: 200px;
}
</style>
</head>
<body>   
	<h2>Edit Item</h2>
	
	<form:form modelAttribute="good" enctype="multipart/form-data" action="${pageContext.request.contextPath}/good/${good.id}" method="PUT">
		<form:input type="hidden" path="id" value="${good.id }" ></form:input>
		<span>Item name: </span><form:input type="text" path="name" value="${good.name }"></form:input>
		<br>
		<form:input type="hidden" path="gallery" value="${good.gallery }"></form:input>
		
		<span>Picture: </span><br> 
		<c:if test="${empty good.gallery}">
			<img id="image" src="" alt="image not found">
		</c:if>
		<c:if test="${!empty good.gallery}">
			<img id="image" src="${pageContext.request.contextPath}/img/${good.category}/${good.gallery.get(0)}" alt="image not found">
		</c:if>
		
		<br>
		<input type="file" name="image"></input>
		<br>
		<span>Price: </span><form:input type="text" path="price" value="${good.price }"></form:input>
		<br>
		<span>Category: </span> 
		<form:select path="category" id="category">
			<c:forEach items="${allCategories }" var="category">
				<c:if test="${category.key == good.category}">
					<option selected="selected" value="${category.key }">${category.value }</option>
				</c:if>
				<c:if test="${category.key != good.category}">
					<option value="${category.key }">${category.value }</option>
				</c:if>
			</c:forEach>	
		</form:select>
		<br>
		<br>
		<input type="submit" value="Update Item"> 
	</form:form>
	<p id="error">${error}<p>
	
	<a href="${pageContext.request.contextPath}/goods/1/5">Go Back</a>	

</body>
</html>