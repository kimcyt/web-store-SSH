<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="cn.ytc.webstore.model.Good"%>
<%@page import="cn.ytc.webstore.model.Category"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageStyle.css">
<style type="text/css">
.content{
	background: white;
	margin: 0;
	padding: 0;
	box-sizing: border box;
}

.commands button{
	width: 80px;
	height: 30px;
	font-size: 18px;
}

.goods-display{
	padding: 30px;
}

.goods-list th{
    margin: 20px;
    font-size: 20px;
    padding: 20px;
}

.goods-list a{
	text-decoration:none;
}

.goods-list a:visited, a:link{
	color: blue;
}

.goods-list a:hover{
	color: #00CCCC
}

</style>
</head>
<body>
	<div class="content">
		<h1>Items Management</h1>
		<br>
		<div class="commands">
			<a href="${pageContext.request.contextPath}/addGood"><button>Add Item</button></a>
		</div>
		<div class="goods-display">
			
			<c:if test="${empty pageInfo}">
				No goods available.
			</c:if>
			
		  	<c:if test="${!empty pageInfo}">
			  	<table class="goods-list">
				  <tr >
				    <th>ID</th>
				    <th>Picture</th>
				    <th>Name</th>
				    <th>Price</th>
				    <th>Category</th>
				    <th>OnSale</th>
				    <th>Edit</th>
				    <th>Delete</th>
				  </tr>
					  <c:forEach items="${pageInfo.pageGoods}" var="good" varStatus="status">
						<tr >
						  <th>${good.id}</th>
						  <th><img src="" alt=""></th>
						  <th>${good.name }</th>
						  <th>${good.price }</th>
						  <th>
						  ${categories.get(good.category) }
						  </th>
						  
						  <th><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getGood&gId=${good.id }&currentPage=${pageInfo.currentPage}">Edit Item</a></th>
						  <th><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=delete&gId=${good.id }&currentPage=${pageInfo.currentPage}">Delete Item</a></th>
						</tr>
					  </c:forEach>
				</table>
			</c:if>
		  	
		</div>
		<div id="page" class="page_div"></div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/paging.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script> -->	
	<script>
	
	    $("#page").paging({
	        pageNo:${pageInfo.currentPage},     /*当前选中的是哪一页*/
	        totalPage: ${pageInfo.totalPages},   /*共多少页*/
	        totalSize: ${pageInfo.totalItems},    /*共多少条记录*/
	        callback: function(num) {
	        	$(window).attr("location", 
	        			"http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage="+num);
	        }  
	    });
	</script>

</body>
</html>