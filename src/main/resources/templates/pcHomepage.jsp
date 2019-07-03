<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/mobileHomepage.jsp";
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
<script type="text/javascript" src="./templets/cloud_04/js/org.js"
	data-main="indexMain"></script>
<title>网上订餐系统</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<div id="sitecontent">
		<div id="indexPage">
			<div id="mslider" class="module">
				<script type="text/javascript">
					$(function() {
						$("#mslider li video").each(function(index, element) {
							element.play();
						});
					})
				</script>
				<ul class="slider" data-options-height="" data-options-auto="1"
					data-options-mode="0" data-options-pause="6"
					data-options-ease="ease-out">
					<li
						style="background-image: url(homeImage/1.jpg)"
						class="active"><div id="tempImage_1"></div> <video
							width="100%" height="100%" autoplay loop preload="auto"
							class="slider-video" style="width:100%; height:auto;"> <source
							src="" type="video/mp4"></source></video>
						<div class="mask"></div> <a target="_blank"><div>
								<p class="title ellipsis">网上订餐系统</p>
								<p class="subtitle">Our online ordering system</p>
							</div>
							<div class="sliderArrow fa fa-angle-down"></div></a></li>
					<li
						style="background-image: url(homeImage/2.jpg)"
						class="active"><div id="tempImage_2"></div> <video
							width="100%" height="100%" autoplay loop preload="auto"
							class="slider-video" style="width:100%; height:auto;"> <source
							src="" type="video/mp4"></source></video>
						<div class="mask"></div> <a target="_blank"><div>
								<p class="title ellipsis">最美味的食物</p>
								<p class="subtitle">Develop a perfect taste for you</p>
							</div>
							<div class="sliderArrow fa fa-angle-down"></div></a></li>
					<li
						style="background-image: url(homeImage/3.jpg)"
						class="active"><div id="tempImage_3"></div> <video
							width="100%" height="100%" autoplay loop preload="auto"
							class="slider-video" style="width:100%; height:auto;"> <source
							src="../7xw3we.com1.z0.glb.clouddn.com/wp-content/uploads/2016/03/01.mp4"
							type="video/mp4"></source></video>
						<div class="mask"></div> <a target="_blank"><div>
								<p class="title ellipsis">最优质的服务</p>
								<p class="subtitle"> Provide you with the best quality service.</p>
							</div>
							<div class="sliderArrow fa fa-angle-down"></div></a></li>

				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>