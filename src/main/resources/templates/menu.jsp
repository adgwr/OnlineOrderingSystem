<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/menu.jsp";
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
					<p class="title">菜品</p>
					<p class="subtitle">PRODUCTS</p>
				</div>
				<div id="searchPart"
					style="height: 10%; line-height: 2%; text-align: center; margin-bottom: 20px;">
					<form id="searchFood" action="GetFoods" method="post">
						<input id="searchContent" type="text" name="searchContent" /> <input
							id="searchButton" type="submit" value="搜索" />
					</form>
				</div>
				<ul id="category">
					<c:forEach var="category" items="${categories}">
						<c:choose>
							<c:when test="${sessionScope.categorySelected eq category.name}">
								<li><a href="javascript:void(0);"
									onclick="categoryClicked('${category.name}');" class="active">${category.name}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:void(0);"
									onclick="categoryClicked('${category.name}');">${category.name}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				<div id="projectlist" class="module-content">
					<div class="wrapper">
						<ul class="content_list">
							<c:forEach var="food" items="${foods}">
								<li class="projectitem">
									<a href="javascript:void(0);" target="_blank" onclick="foodclicked('${food.foodID}');">
										<div class="project_img">
											<img src="foodImage/${food.imagePath}" width="500" height="320" />
										</div>
										<div class="project_info">
											<div>
												<p class="title">${food.name}</p>
												<p class="subtitle">${food.subName}</p>
											</div>
										</div>
								</a> <a href="" target="_blank" class="details">更多<i
										class="fa fa-angle-right"></i></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
				<div id="pages"></div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function foodclicked(foodID){
	        form = $("<form></form>")
	        form.attr('action','AddShoppingCart')
	        form.attr('method','post')
	        form.attr('accept-charset','UTF-8')
	        input1 = $("<input type='hidden' name='foodID'/>")
	        input1.attr("value",foodID)
	        form.append(input1)
	        form.appendTo("body")
	        form.css('display','none')
	        form.submit()
		}
	</script>
</body>
</html>