<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cn.ytc.webstore.utils.PageInfo"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Web Store</title>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageStyle.css">
</head>
<body>

	<div class="container">
		<%@ include file="header.jsp"%>
		
		<div class="header_bottom row">
			<nav class="col-md-12 navbar navbar-expand-lg navbar-light bg-light"> 
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<c:if test="${empty currentCategory}">
								<a class="nav-link active" href="${pageContext.request.contextPath}/goods/1/20/">All Items
									<span class="sr-only">(current)</span>
								</a>
							</c:if>
							<c:if test="${!empty currentCategory}">
								<a class="nav-link" href="${pageContext.request.contextPath}/goods/1/20/">All Items
									<span class="sr-only">(current)</span>
								</a>
							</c:if>
						</li>
						<c:forEach items="${allCategories}" var="category">
							<c:if test="${currentCategory==category.key}">
								<li class="nav-item">
								<a class="nav-link active" href="${pageContext.request.contextPath}/goods/1/20/${category.key}">${category.value}</a>
								</li>
							</c:if>
							<c:if test="${currentCategory!=category.key}">
								<li class="nav-item">
								<a class="nav-link" href="${pageContext.request.contextPath}/goods/1/20/${category.key}">${category.value}</a>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</nav>
		</div>
		
		<div class="row" >
			<div id="carouselIndicators" class="carousel slide col-md-12 ads"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselIndicators" data-slide-to="1"></li>
					<li data-target="#carouselIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block" src="${pageContext.request.contextPath}/img/ad1.jpg">
					</div>
					<div class="carousel-item">
						<img class="d-block" src="${pageContext.request.contextPath}/img/ad2.jpg">
					</div>
					<div class="carousel-item">
						<img class="d-block" src="${pageContext.request.contextPath}/img/ad3.jpg">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

	<!--  
		<div class="on_sale" >
			<div class="title row">
				<h2>Items On Sale</h2> 
			</div>
				<ul class="row">
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
				</ul>
		</div>
	-->
		
		<div class="regular-items">
			<div class="title row">
				<h2>Regular Items</h2>
			</div>
			<ul class="items row">
				<c:forEach items="${pageInfo.pageGoods}" var="good" varStatus="status">
				<li class="items col-3 h-60">
					<a href="${pageContext.request.contextPath}/good/${good.id}"> <img src="${pageContext.request.contextPath}/img/${good.category}/${good.gallery.get(0)}"></a>
					<p class="item-name">${good.name}</p>
					<p class="item-price">$${good.price}</p>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div id="page" class="page_div"></div>
		<p id="error"><p>
		<%@ include file="footer.jsp"%>

	</div>
	
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/paging.js"></script>
	<script>
	    $("#page").paging({
	    	pageNo:${pageInfo.currentPage},     /*当前选中的是哪一页*/
	        totalPage: ${pageInfo.totalPages},   /*共多少页*/
	        totalSize: ${pageInfo.totalItems},    /*共多少条记录*/
	        callback: function(num) {
	        	$(window).attr("location", 
	        			"${pageContext.request.contextPath}/goods/"+num+"/5");
	        }  
	    });
	</script>
	<script>
		//todo: create apis to retrive images and item info, use js to dynamiclly display them
	</script>

</body>
</html>