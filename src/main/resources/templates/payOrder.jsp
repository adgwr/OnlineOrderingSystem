<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<title>订单支付</title>
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
	<!--订单提交body部分开始-->
	<div class="border_top_cart">

		<div class="container payment-con">
			<form target="_blank" action="PayOrder" id="pay-form" method="post"
				style="margin-top: 100px;">
				<div class="order-info">
					<div class="msg">
						<h3>您的订单已提交成功！请付款</h3>
						<p></p>

					</div>
					<div class="info">
						<p>
							金额：<span class="pay-total">${requestScope.totalPrice}元</span>
						</p>
						<p>订单：${requestScope.orderID}</p>
						<p>
							配送：${requestScope.reName} <span class="line">/</span>
							${requestScope.reTel} <span class="line">/</span>
							${requestScope.reAddress}
						</p>
					</div>
					<div class="icon-box">
						<i class="iconfont"><img src="images/yes_ok.png"></i>
					</div>
				</div>

				<div class="xm-plain-box">
					选择支付方式

					<div class="box-bd" id="bankList">
						<div class="payment-bd">
							<dl class="clearfix payment-box">
								<dt>
									<strong>支付平台</strong>
									<p>手机等大额支付推荐使用支付宝快捷支付</p>
								</dt>
								<dd>
									<fieldset id="test4-input-input_tab1-input_tab2"
										style="border: none;">
										<ul class="payment-list clearfix">
											<li><input class="input_tab2" name="myradio" id="r1"
												type="radio" checked="checked" /><label for="r1"><img style="height:50px;"
													src="images/zfb.png" alt="" /></label></li>
											<li><input class="input_tab2" name="myradio" id="r2"
												type="radio" /><label for="r2"><img style="height:50px;"
													src="images/wxzf.jpg" alt="" /></label></li>
											<li><input class="input_tab2" name="myradio" id="r3"
												type="radio" /><label for="r3"><img style="height:50px;"
													src="images/zxzf.png" alt="" /></label></li>
										</ul>
									</fieldset>
								</dd>
							</dl>

						</div>
					</div>
					<div class="box-ft clearfix">
						<input type="hidden" name="orderPrice"
							value="${requestScope.totalPrice}" /> <input type="hidden"
							name="orderID" value="${requestScope.orderID}" /> <input
							type="submit" class="btn btn-primary" value="下一步" id="payBtn">
						<a href="CancelOrder?orderID=${requestScope.orderID}"
							class="btn btn-lineDakeLight" style="float:left">取消订单</a> <span class="tip"></span>
					</div>
				</div>
			</form>
		</div>

		<script src="js/base.min.js"></script>

		<script type="text/javascript" src="js/buyConfirm.js"></script>

	</div>


	<!--订单提交body部分结束-->
	<jsp:include page="footer.jsp" />

</body>
</html>