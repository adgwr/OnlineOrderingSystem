<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
	data-main="indexMain"></script>
<jsp:include page="banner.jsp" />
</head>
<body>


	<!--收货地址body部分开始-->
	<div class="border_top_cart">
		<script type="text/javascript">
			var checkoutConfig = {
				addressMatch : 'common',
				addressMatchVarName : 'data',
				showCouponBox : 0,

			};
			var miniCartDisable = true;
		</script>
		<div class="container">
			<div class="checkout-box">
				<form id="checkoutForm" name="checkoutForm" action="MakeOrder" method="post">
					<div class="checkout-box-bd">
						<!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
						<input type="hidden" name="Checkout[addressState]" id="addrState"
							value="0" />
						<!-- 收货地址 -->
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">收货地址</h2>
								<!---->
							</div>
							<div class="box-bd">
								<div class="clearfix xm-address-list" id="checkoutAddrList" style="margin-top:80px">

									<c:forEach var="receiver" items="${requestScope.receiverList}">
										<jsp:useBean id="receiver" class="entity.Receiver" />
										<dl class="item">
											<dt>
												<strong class="itemConsignee"><jsp:getProperty
														property="name" name="receiver" /></strong>
											</dt>
											<dd>
												<p class="tel itemTel"><jsp:getProperty property="tel"
														name="receiver" /></p>
												<p class="itemStreet"><jsp:getProperty
														property="address" name="receiver" /></p>
												<br> <a
													href='modReceiver.jsp?id=${receiver.receiverID}&name=${receiver.name}&tel=${receiver.tel}&address=${receiver.address}'
													style="float: left">编辑</a> <a
													href='DeleteReceiver?id=${receiver.receiverID}'
													style="float: right">删除</a>
											</dd>
											<dd style="display: none">
												<input type="radio" class="addressId" checked="checked"
													name="receiverID" value="${receiver.receiverID}" />
											</dd>
										</dl>
									</c:forEach>
									<dl class="item" style="border: 1px dashed #dfdfdf;" onclick="javascript:window.location.href='addReceiver.jsp'">
										<img src="images/add_cart.png"/>
									</dl>
								</div>

							</div>
						</div>
						<!-- 收货地址 END-->
						<div id="checkoutPayment">
							<!-- 支付方式 -->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">支付方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutPaymentList"
										class="checkout-option-list clearfix J_optionList">
										<li class="item selected"><input type="radio"
											name="Checkout[pay_id]" checked="checked" value="1" />
											<p>
												在线支付 <span></span>
											</p></li>
									</ul>
								</div>
							</div>
							<!-- 支付方式 END-->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">配送方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutShipmentList"
										class="checkout-option-list clearfix J_optionList">
										<li class="item selected"><input type="radio"
											id="Checkout[shipment_id]" name="Checkout[shipment_id]"
											checked="checked" value="0" />
											<p>
												快递配送（免运费） <span></span>
											</p></li>
										<li class="item "><input type="radio"
											id="Checkout[shipment_id]" name="Checkout[shipment_id]"
											value="1" />
											<p>
												到店自取 <span></span>
											</p></li>
									</ul>
								</div>
							</div>
							<!-- 配送方式 END-->
							<!-- 配送方式 END-->
						</div>
					</div>
					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">确认订单信息</h2>
								</div>
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-1">商品名称</span> <span class="col col-2">购买价格</span>
											<span class="col col-3">购买数量</span> <span class="col col-4">小计（元）</span>
										</dt>
										<c:forEach var="lineItem" items="${sessionScope.lineItemList}">
											<jsp:useBean id="lineItem" class="entity.LineItem" />
											<dd class="item clearfix">
												<div class="item-row">
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
													<div class="col col-3"><jsp:getProperty
															property="amount" name="lineItem" /></div>
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
											<ul>

												<li>订单总额：<span>${requestScope.orderPrice} 元</span>
												</li>
												<li>运费：<span id="postageDesc">0元</span>
												</li>
											</ul>
											<p class="checkout-total">
												应付总额：<span><strong id="orderPrice">${requestScope.orderPrice}</strong>元</span>
											</p>
										</div>
										<!--  -->
									</div>
								</div>
							</div>

						</div>
						<!-- 商品清单 END -->
						<input type="hidden" id="couponType" name="Checkout[couponsType]" />
						<input type="hidden" id="couponValue"
							name="Checkout[couponsValue]" />
						<div class="checkout-confirm">

							<a href="ShoppingCart"
								class="btn btn-lineDakeLight btn-back-cart">返回购物车</a> <input
								 class="btn btn-primary" value="立即下单" onclick="hasReceiver();"
								id="checkoutToPay" style="float:right"/>
						</div>
					</div>
				</form>
			</div>



		</div>



		<script src="js/base.min.js"></script>

		<script type="text/javascript" src="js/address_all.js"></script>
		<script type="text/javascript" src="js/checkout.min.js"></script>
	</div>

	<!--收货地址body部分结束-->

	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="js/unslider.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>
	<script>
		function hasReceiver(){
			var Flag = false;
			var receiverBox = document.getElementsByName('receiverID');
			for(var i=0;i<receiverBox.length; i++){
				if(receiverBox[i].checked) {
					Flag = true;
					break;
				}
			}
			if(Flag==false) {
				alert('收货人地址不能为空');
			}else{
				document.checkoutForm.action = "MakeOrder";
				document.checkoutForm.submit();
			}
		}
	</script>
	<script>
		$("#checkoutShipmentList li").click(function() {
			$(this).siblings(".selected").removeClass("selected");
			$(this).addClass("selected");
			$(this).siblings(".selected").children().removeAttr("checked");
			$(this).children().attr("checked", "checked");
		});
	</script>
</body>
<head><jsp:include page="footer.jsp" />
</head>

</html>