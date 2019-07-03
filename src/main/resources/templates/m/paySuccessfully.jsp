<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="effect">
<head>
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<meta http-equiv="refresh" content="5;URL=../GetOrders">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="UEMO">
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
<title>订单-网上订餐系统</title>
</head>
<body>
	<div id="sitecontent" class="transform">
		<jsp:include page="banner.jsp" />
		<div class="scrollView">
			<div class="npagePage">
				<div class="content">
					<div id="category">
						<div class="label plr20">
							<div class="text">付款成功</div>
						</div>
					</div>
					<div class="border_top_cart">
						<div class="container payment-con">
							<div class="order-info"
								style="margin-top: 20px;width:100%; text-align: center;">
								<div class="msg">
									<h1 style="color:green;">付款成功！</h1>
									<p></p>
								</div>
								<div class="info" style="color: white;">
									<p style="margin:15px;font-size:1.3em;">
										金额：<span class="pay-total">${requestScope.totalPrice}元</span>
									</p>
									<p style="margin:15px;font-size:1.3em;">订单号：${requestScope.orderID}</p>
									<p style="margin:15px;font-size:1.3em;">5秒后跳转到订单页面...</p>
								</div>
							</div>
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
		data-main="IndexMain"></script>
</html>