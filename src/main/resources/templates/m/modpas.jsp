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
			window.location.href = "../customer/index.jsp";
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
							<div class="text">修改密码</div>
						</div>
					</div>
					<div id="login" style="margin-top: 60px" class="input_control">
						<form name="f"
							action="${pageContext.request.contextPath}/ModifyPwdCustomer"
							method="POST">
							<p style="font-size: 2em; color: white; text-align: center;">在此修改您的密码</p>
							<p style="margin-top: 60px; text-align: center;">
								<label style="color: white; font-size: 1.4em">您的账号：</label> <input
									type="text"
									style="border: white 1px solid; color: gray; border-radius: 3px; padding: 5px"
									name="CustomerID" id="CustomerID" maxlength="20" value="${user.c_id}" disabled="disabled"/>
							</p>

							<p style="margin-top: 30px; text-align: center;">
								<label style="color: white; font-size: 1.4em">原始密码：</label> <input
									type="password"
									style="border: white 1px solid; color: white; border-radius: 3px; padding: 5px"
									name="oldPswd" id="oldPswd" maxlength="16"/>
							</p>

							<p style="margin-top: 30px; text-align: center;">
								<label style="color: white; font-size: 1.4em">新的密码：</label><input
									style="border: white 1px solid; color: white; border-radius: 3px; padding: 5px"
									name="newPswd" id="newPswd" type="password" maxlength="16" />
							</p>
							
							<p style="margin-top: 30px; text-align: center;">
								<label style="color: white; font-size: 1.4em">确认密码：</label><input
									style="border: white 1px solid; color: white; border-radius: 3px; padding: 5px"
									name="confirm" id="confirm" type="password" maxlength="16" />
							</p>


							<p
								style="margin-top: 30px; margin-bottom: 150px; text-align: center;">
								<input type="button" value="修        改"
									style="border-radius: 3px; color: white; margin-left: 10px; cursor: pointer; border: white 1px solid; padding: 6px 50px; font-size: 1.4em;"
									onclick="Modify();" />
							</p>
						</form>
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
	<script type="text/javascript">
		function Modify() {
			var isemail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			var istel = /^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$/;
			var simplepas = /^[0-9]{6,16}$|^[a-zA-Z]{6,16}$/;
			if ($("#oldPswd").val() == "") {
				alert('请输入旧密码！');
				return;
			}
			if ($("#newPswd").val() == ""){
				alert('请输入新密码!')
				return
			}
			if($("#newPswd").val() != $("#confirm").val()){
				alert('两次输入密码不一致!')
				return
			}
			if(simplepas.test($("#newPswd").val())  ){
				alert('新密码太过简单!')
				return
			}
			document.f.submit();
		}
	</script>
</html>