<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta name="author" content="GF">
<script type="text/javascript">
	try {
		if (!(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent))) {
			window.location.href = "../pcHomepage.jsp";
		}
	} catch (e) {
	}
</script>
<link type="text/css"
      href="../../static/templets/cloud_04/style/font-awesome.min.css" rel="stylesheet"
      media="all">
<link type="text/css" href="../../static/templets/cloud_04/style/bxslider.min.css"
	rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css"
      href="../../static/templets/cloud_04/style/animate.min.css" media="all">
<link type="text/css" href="../../static/templets/cloud_04/style/stylem.css"
	rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css"
      href="../../static/templets/cloud_04/style/376m.css" media="all">
<title>网上订餐系统</title>
</head>
<body>
	<div id="sitecontent" class="transform">
		<jsp:include page="banner.jsp" />
		<div class="scrollView">
			<div id="indexPage">
				<div id="mslider">
					<ul class="slider">
						<li style="background-image: url(../../static/homeImage/1.jpg)"><a>
								<div>
									<p class="title ellipsis">网上订餐系统</p>
									<p class="subtitle">Our online ordering system</p>
								</div>
						</a></li>
						<li style="background-image: url(../../static/homeImage/2.jpg)"><a>
								<div>
									<p class="title ellipsis">最美味的食物</p>
									<p class="subtitle">Develop a perfect taste for you</p>
								</div>
						</a></li>
						<li style="background-image: url(../../static/homeImage/3.jpg)"><a><div>
									<p class="title ellipsis">最优质的服务</p>
									<p class="subtitle">Provide you with the best quality
										service.</p>
								</div></a></li>

					</ul>
				</div>
				<div id="mcontact" class="module">
					<div class="content plr10 wow fadeIn">
						<div class="header">
							<p class="title">联系我们</p>
							<p class="subtitle">CONTACT</p>
						</div>
						<div id="contactlist">
							<div id="contactinfo">
								<h3 class="ellipsis">网上订餐系统文化传播有限公司</h3>
								<p class="ellipsis">地点：Do You Best,Mutually Promote
									Symbiosis</p>
								<p class="ellipsis">邮编：4651122</p>
								<p class="ellipsis">电话：0123-45678910</p>
								<p class="ellipsis">手机：12345678910</p>
								<p class="ellipsis">邮箱：网上订餐系统@123.com</p>
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
