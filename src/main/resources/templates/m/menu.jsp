<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="effect">
<head>
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta name="keywords" content="">
<meta name="description" content="PRODUCTS">
<meta name="author" content="UEMO">
<script type="text/javascript">
	try {
		if (!(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent))) {
			window.location.href = "../menu.jsp";
		}
	} catch (e) {
	}
</script>
<link type="text/css"
      href="../../static/templets/cloud_04/style/font-awesome.min.css" rel="stylesheet">
<link type="text/css" href="../../static/templets/cloud_04/style/bxslider.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../../static/templets/cloud_04/style/animate.min.css">
<link type="text/css" href="../../static/templets/cloud_04/style/stylem.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../../static/templets/cloud_04/style/376m.css">
<title>菜品-网上订餐系统</title>
</head>
<body>
	<div id="sitecontent" class="transform">
		<jsp:include page="banner.jsp" />
		<div class="scrollView">
			<div class="npagePage">
				<div class="content">
					<div id="category" class="dropmenu">
						<div class="label plr20">
							<i class="down fa fa-angle-down transform"></i>
							<div class="text"></div>
						</div>
						<ul class="transform" data-height_bak="246" data-height="auto">
							<c:forEach var="category" items="${categories}">
								<c:choose>
									<c:when test="${sessionScope.categorySelected eq category.name}">
										<li><a href="javascript:void(0);"
											onclick="categoryClicked('${category.name}');" class="active">${category.name}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="javascript:void(0);"
											onclick="categoryClicked('${category.name}');">${category.name}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
					<div id="searchPart" style="text-align: center;">
						<form id="searchFood" name="searchFood" action="menu.jsp"
							method="post">
							<input id="searchContent" type="text" name="searchContent" /> <input
								id="searchButton" type="image" src="../../static/logoImage/search.png"
								onclick="document.searchFood.submit();" />
						</form>
					</div>
					<div id="projectlist">
						<div class="wrapper plr5">
							<c:forEach var="food" items="${foods}">
								<div class="projectitem wow fadeIn">
									<a href="javascript:void(0);" onclick="foodclicked('${food.foodID}');"><img
										src="../foodImage/${food.imagePath}" width="500" height="320" />
										<div class="project_info">
											<div>
												<p class="title">${food.name}</p>
												<p class="subtitle">${food.subName}</p>
											</div>
										</div> </a>
								</div>
							</c:forEach>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="footer.jsp" />
					<div id="bgmask" class="iPage hide"></div>
		</div>
	</div>
	<jsp:include page="leftcontrol.jsp" />
	<script type="text/javascript"
		src="../../static/templets/cloud_04/js/zepto.min.js"></script>
	<script type="text/javascript"
		src="../../static/templets/cloud_04/js/zepto.bxslider.min.js"></script>
	<script type="text/javascript" src="../../static/templets/cloud_04/js/wow.min.js"></script>
	<script type="text/javascript"
		src="../../static/templets/cloud_04/js/masonry_4.min.js"></script>
	<script type="text/javascript" src="../../static/templets/cloud_04/js/org.min.js"
		data-main="ListMain"></script>
	<script type="text/javascript">
		function foodclicked(foodID){
	        form = $("<form></form>")
	        form.attr('action','../AddShoppingCart')
	        form.attr('method','post')
	        form.attr('accept-charset','UTF-8')
	        input1 = $("<input type='hidden' name='foodID'/>")
	        input1.attr("value",foodID)
	        form.append(input1)
	        form.appendTo("body")
	        form.css('display','none')
	        form.submit()
		}
	</script>
</html>