<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/orderList.jsp";
		}
	} catch (e) {
	}
</script>
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/lib.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/style.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/376.css" />
<script type="text/javascript"
	src="templets/cloud_04/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="templets/cloud_04/js/org.js"
	data-main="baseMain"></script>
<title>菜品-网上订单系统</title>
</head>
<body class="nobanner">
	<jsp:include page="banner.jsp"></jsp:include>

	<div id="sitecontent">
		<div class="npagePage Pageanli" id="mproject">
			<div class="content">
				<div class="header" id="plheader">
					<p class="title">我的订单</p>
					<p class="subtitle">My Orders</p>
				</div>
				<div id="showOrders">
					<table>
						<tr id="line1">
							<th>商品</th>
							<th>价格</th>
							<th>收件人</th>
							<th>时间</th>
							<th>交货方式</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach var="order" items="${orders}">
							<tr id="otherLine">
								<td><table>
										<c:forEach var="lineItem" items="${order.lineItems}">
											<tr>
												<td>${lineItem.name} × ${lineItem.amount}</td>
											</tr>
										</c:forEach>
									</table></td>
								<td><table>
										<c:forEach var="lineItem" items="${order.lineItems}">
											<tr>
												<td>${lineItem.totalPrice}</td>
											</tr>
										</c:forEach>
									</table></td>
								<td>${order.receiver.name}</td>
								<td>${order.date}</td>
								<td>${order.shipMethod}</td>
								<td id="state">${order.state}</td>
								<td>
								<c:if test="${order.state eq '未付款' or order.state eq '已付款'}">
										<form action="./CancelOrder" method="post"
											onsubmit="return cancelForm();">
											<input type="hidden" name="orderID" value="${order.orderID}" />
											<input id="cancel" type="submit" value="取消订单" />
										</form>
								</c:if>
								<c:if test="${order.state eq '未付款'}">
										<form action="./PayNow" method="post">
											<input type="hidden" name="orderToPay" value="${order.orderID}" />
											<input id="pay" type="submit" value="立即付款" />
										</form>
								</c:if>
								<c:if test="${order.state eq '正在配送'}">
										<form action="./FinishOrder" method="post">
											<input type="hidden" name="orderID" value="${order.orderID}" />
											<input id="finish" type="submit" value="确认收货" />
										</form>
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="clear"></div>
				<div id="pages"></div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
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
</body>
</html>