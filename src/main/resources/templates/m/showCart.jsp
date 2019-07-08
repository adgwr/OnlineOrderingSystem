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
			window.location.href = "../showCart.jsp";
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
<style>
.button {
	width: 8rem;
	height: 3.5rem;;
	background-color: transparent;
	color: #cfcfcf;
	font-size: 1.1rem;
	border: 1.5px solid rgba(255, 255, 255, .2);
	border-radius: 5px;
	text-align:center;
	margin-top:15px;
	margin-bottom:200px;
	margin-left:7px;
	margin-right:7px;
}

table {
	border: 0.5px solid #606060;
	color: #fff;
	background-color: transparent;
	width: 90%;
	border-collapse: collapse;
	margin: auto;
	margin-top: 30px;
	border-radius: 1px;
	margin-bottom : 80px;
}

table tr th {
	border: 0.5px solid #606060;
	font-size: 1.1em;
	padding: 5px 10px;
	font-family: "Times New Roman", "微软雅黑";
}

table tr td {
	border: 1px solid #606060;
	font-size: 1em;
	text-align: center;
	font-family: "Times New Roman", "微软雅黑";
	padding: 3px;
}
</style>
</head>
<body>
	<div id="sitecontent" class="transform">
		<jsp:include page="banner.jsp" />
		<div class="scrollView">
			<div class="npagePage">
				<div class="content">
					<div id="category">
						<div class="label plr20">
							<div class="text">购物车</div>
						</div>
					</div>
					<form id="checkoutForm" name="checkoutForm"
								action="DeleteShoppingCart" method="post">
					<table>
						<tr>
							<th><input type="checkbox" id="selectAllItems"
								name="selectAllItems" onclick="selectall();renewprice();" /></th>
							<th>商品名称</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach var="lineItem" items="${sessionScope.lineItemList}">
							<jsp:useBean id="lineItem" class="entity.LineItem" />
							<tr>
								<td><input id="itemselected" name="itemselected"
									type="checkbox" value="${lineItem.foodID}"
									onclick="renewprice();" price="${lineItem.totalPrice}" /></td>

								<td><a href="#" style="color: white;"><jsp:getProperty
											property="name" name="lineItem" /></a></td>
								<td>￥<jsp:getProperty property="price" name="lineItem" />
								</td>
								<td><jsp:getProperty property="amount" name="lineItem" /></td>
								<td>￥<jsp:getProperty property="totalPrice" name="lineItem" /></td>
							</tr>
						</c:forEach>
					</table>
					<span style="font-size: 20px;color:white; float:right;margin-right:20px;">总额：<strong
						id="orderPrice">0.00</strong>元
					</span> <input type="hidden" id="couponType" name="Checkout[couponsType]" />
					<input type="hidden" id="couponValue" name="Checkout[couponsValue]" />
					<div style="float:right;margin-right:15px;">
					<input class="button" value="删除所选项" onclick="deleteSC();" /> 
					<input onclick="categoryClicked('全部');" class="button" value="继续添加" /> 
					<input class="button" value="结算" onclick="makeorder();" />
					</div>
					</form>
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
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="js/unslider.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>
	<script type="text/javascript">
		function selectall() {
			var selectbox = document.getElementById('selectAllItems');
			var checkboxs = document.getElementsByName('itemselected');

			if (selectbox.checked == true) {
				for (var i = 0; i < checkboxs.length; i++) {
					checkboxs[i].checked = true;
				}
			} else {
				for (var i = 0; i < checkboxs.length; i++) {
					checkboxs[i].checked = false;
				}
			}
		}
		function deleteSC() {
			document.checkoutForm.action = "../DeleteShoppingCart";
			document.checkoutForm.submit();
		}
		function makeorder() {
			var Flag = false;
			var checkboxs = document.getElementsByName('itemselected');
			for (var i = 0; i < checkboxs.length; i++) {
				if (checkboxs[i].checked) {
					Flag = true;
					break;
				}
			}
			if (Flag == false) {
				alert('您还未选择任何食品！');
			} else {
				document.checkoutForm.action = "../PrepareOrder";
				document.checkoutForm.submit();
			}
		}
		function renewprice() {
			var checkboxs = document.getElementsByName('itemselected');
			var totalprice = 0.00;
			for (var i = 0; i < checkboxs.length; i++) {
				if (checkboxs[i].checked) {
					totalprice = parseFloat(checkboxs[i].getAttribute("price"))
							+ parseFloat(totalprice);
				}
			}
			document.getElementById("orderPrice").innerHTML = totalprice
					.toFixed(2);
		}
	</script>
</html>