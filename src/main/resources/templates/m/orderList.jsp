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
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="UEMO">
<script type="text/javascript">
	try {
		if (!(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent))) {
			window.location.href = "../orderList.jsp";
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
							<div class="text">我的订单</div>
						</div>
					</div>
					<ul id="orderlist">
						<c:forEach var="order" items="${orders}">
							<li class="orderitem">
								<p class="date">${order.date}${order.shipMethod}
									${order.receiver.name}收 （${order.state}）</p>
								<div class="lineitems">
									<c:forEach var="lineItem" items="${order.lineItems}">
										<div class="lineitem">${lineItem.name}×
											${lineItem.amount}</div>
									</c:forEach>
								</div>
								<div class="prices">
									<c:forEach var="lineItem" items="${order.lineItems}">
										<div class="price">￥${lineItem.totalPrice}</div>
									</c:forEach>

									<c:if test="${order.state eq '未付款' or order.state eq '已付款'}">
										<form action="../CancelOrder" method="post"
											onsubmit="return cancelForm();">
											<input type="hidden" name="orderID" value="${order.orderID}" />
											<input type="submit" value="取消订单" class="cancelButton" />
										</form>
									</c:if>
									<c:if test="${order.state eq '未付款'}">
										<form action="../PayNow" method="post">
											<input type="hidden" name="orderToPay" value="${order.orderID}" />
											<input type="submit" value="立即付款" class="cancelButton" style="margin-top:7px"/>
										</form>
									</c:if>
									<c:if test="${order.state eq '已接单'}">
										<form action="../FinishOrder" method="post">
											<input type="hidden" name="orderID" value="${order.orderID}" />
											<input type="submit" value="确认收货" class="cancelButton" />
										</form>
									</c:if>
								</div>
						</c:forEach>
					</ul>
				</div>
			</div>
			<jsp:include page="footer.jsp" />
			<div id="bgmask" class="iPage hide"></div>
			-->
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
	<script type="text/javascript">
		function cancelForm() {
			var ask = confirm("是否取消改订单？");
			if (ask == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</html>