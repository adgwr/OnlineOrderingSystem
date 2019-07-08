<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/paySuccessfully.jsp";
		}
	} catch (e) {
	}
</script>
<meta content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="5;URL=GetOrders">
<title>支付成功</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="js/jquery_cart.js"></script>
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/unslider.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/lib.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/style.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/376.css" />
<script type="text/javascript"
	src="templets/cloud_04/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./templets/cloud_04/js/org.js"
	data-main="indexMain"></script>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<div class="border_top_cart">
		<div class="container payment-con">
			<div class="order-info" style="margin-top: 100px;">
				<div class="msg">
					<h3>付款成功！</h3>
					<p></p>

				</div>
				<div class="info">
					<p>
						金额：<span class="pay-total">${requestScope.totalPrice}元</span>
					</p>
					<p>订单号：${requestScope.orderID}</p>
					<p>5秒后跳转到订单页面...</p>
				</div>
				<div class="icon-box">
					<i class="iconfont"><img src="images/yes_ok.png"></i>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>