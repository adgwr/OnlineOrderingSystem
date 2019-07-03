<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/showCart.jsp";
		}
	} catch (e) {
	}
</script>
<meta content="text/html; charset=utf-8">
<title>网上订餐系统</title>
<link href="${pageContext.request.contextPath}/css/public.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery_cart.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/checkOut.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/lib.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/style.css" />
<link rel="stylesheet" type="text/css"
	href="templets/cloud_04/style/376.css" />
<script type="text/javascript"
	src="templets/cloud_04/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./templets/cloud_04/js/org.js"
	data-main="baseMain"></script>
</head>
<body>

<body class="nobanner">
	<jsp:include page="banner.jsp"></jsp:include>


	<div id="sitecontent">
		<div class="npagePage">
			<div class="content">
				<div class="header" id="plheader">
					<p class="title">购物车</p>
					<p class="subtitle">SHOPPINGCART</p>
				</div>

	<!--收货地址body部分开始-->
	<div class="border_top_cart">
		<div class="container">
			<div class="checkout-box">
				<form id="checkoutForm" name="checkoutForm" action="DeleteShoppingCart" method="post">

					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-4"> <input type="checkbox"
												id="selectAllItems" name="selectAllItems"
												onclick="selectall();renewprice();" />全选
											</span> <span class="col col-1">商品名称</span> <span class="col col-2">价格</span>
											<span class="col col-3">数量</span> <span class="col col-4">小计（元）</span>
										</dt>
										<c:forEach var="lineItem" items="${sessionScope.lineItemList}">
											<jsp:useBean id="lineItem" class="entity.LineItem" />


											<dd class="item clearfix">
												<div class="item-row">
													<div class="col col-4">
														<input id="itemselected" name="itemselected"
															type="checkbox" value="${lineItem.foodID}" onclick="renewprice();" price="${lineItem.totalPrice}"
															 />

													</div>
													<div class="col col-1">
														<div class="g-pic">
															<img src="foodImage/${lineItem.imagePath}" width="40"
																height="40" />
														</div>
														<div class="g-info">
															<a href="#"><jsp:getProperty property="name"
																	name="lineItem" /></a>
														</div>
													</div>

													<div class="col col-2"><jsp:getProperty
															property="price" name="lineItem" />元
													</div>
													<div class="col col-3">
														<div class="col col-5">
															<a
																href="ModifyShoppingCart?modifyType=add&foodID=${lineItem.foodID}"><img
																src="images/+.png" /></a>
														</div>

														<div class="col col-6"><jsp:getProperty
																property="amount" name="lineItem" /></div>


														<div class="col col-5" align="center">
															<a
																href="ModifyShoppingCart?modifyType=minus&foodID=${lineItem.foodID}"><img
																src="images/-.png" /></a>
														</div>


													</div>
													<div class="col col-4"><jsp:getProperty
															property="totalPrice" name="lineItem" />元
													</div>
												</div>
											</dd>
										</c:forEach>
									</dl>
									<div class="checkout-count clearfix">
										<!-- checkout-count-extend -->
										<div class="checkout-price">
											<p class="checkout-total">
												总额：<span><strong id="orderPrice">0</strong>元</span>
											</p>
										</div>
									</div>
								</div>
							</div>

						</div>
						<!-- 商品清单 END -->
						<input type="hidden" id="couponType" name="Checkout[couponsType]" />
						<input type="hidden" id="couponValue"
							name="Checkout[couponsValue]" />
						<div class="checkout-confirm">

							<input class="btn btn-primary" value="删除所选项"
								id="checkoutToPay" onclick="deleteSC();" /> <a
								href="javascript:void(0);" onclick="categoryClicked('全部');"
								class="btn btn-lineDakeLight btn-back-cart">继续添加</a> <input
								class="btn btn-primary" value="结算" onclick="makeorder();"
								id="checkoutToPay" />
						</div>
					</div>
				</form>
			</div>

		</div>

		<script src="js/base.min.js"></script>

		<script type="text/javascript" src="js/address_all.js"></script>
		<script type="text/javascript" src="js/checkout.min.js"></script>
	</div>
</div>
</div>
</div>
	<!--收货地址body部分结束-->
	<jsp:include page="footer.jsp" />
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
			document.checkoutForm.action = "DeleteShoppingCart";
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
				document.checkoutForm.action = "PrepareOrder";
				document.checkoutForm.submit();
			}
		}
		function renewprice() {
			var checkboxs = document.getElementsByName('itemselected');
			var totalprice = 0.00;
			for (var i = 0; i < checkboxs.length; i++) {
				if (checkboxs[i].checked) {
					totalprice = parseFloat(checkboxs[i].getAttribute("price")) + parseFloat(totalprice);
				}
			}
			//totalPrice.toFixed(2);
			document.getElementById("orderPrice").innerHTML = totalprice.toFixed(2);
		}
	</script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="js/unslider.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>

</body>
</html>