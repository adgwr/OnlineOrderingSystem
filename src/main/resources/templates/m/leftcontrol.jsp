<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="../../static/templets/cloud_04/js/jquery-1.11.3.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="leftcontrol">
		<ul id="nav">
			<c:if test="${sessionScope.type=='admin'}">
				<li class="navitem active"><a class="transform"
				href="javascript:void(0);"><span
					class="circle transform"></span>管理员请在电脑登陆！</a></li>
			</c:if>
			<li class="navitem active"><a class="transform"
				href="mobileHomepage.jsp"><span class="circle transform"></span>首页</a></li>
			<li class="navitem active"><a class="transform"
				href="javascript:void(0);" onclick="categoryClicked('全部');"><span
					class="circle transform"></span>菜品</a></li>
			<c:if test="${sessionScope.type=='' or sessionScope.type==null}">
					<li class="navitem active"><a class="transform"
						href="login.jsp"><span class="circle transform"></span>登陆</a></li>	
					<li class="navitem active"><a class="transform"
						href="register.jsp"><span class="circle transform"></span>注册</a></li>	
			</c:if>
			<c:if test="${sessionScope.type=='customer'}">
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/m/perInfo.jsp"><span
						class="circle transform"></span>我的信息</a></li>
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/m/modInfo.jsp"><span
						class="circle transform"></span>修改信息</a></li>
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/m/modpas.jsp"><span
						class="circle transform"></span>修改密码</a></li>
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/GetOrders" target="_self"><span
						class="circle transform"></span>我的订单</a></li>
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/ShoppingCart"
					target="_self"><span class="circle transform"></span>购物车</a></li>
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/Logout"
					target="_self"><span class="circle transform"></span>退出</a></li>
			</c:if>
			<c:if test="${sessionScope.type=='admin'}">
				<li class="navitem active"><a class="transform"
					href="${pageContext.request.contextPath}/Logout"
					target="_self"><span class="circle transform"></span>退出</a></li>
			</c:if>
		</ul>
	</div>
	<script type="text/javascript">
		function categoryClicked(category) {
			form = $("<form></form>")
			form.attr('action', '../GetFoods')
			form.attr('method', 'post')
			form.attr('accept-charset', 'UTF-8')
			input1 = $("<input type='hidden' name='categorySelected'/>")
			input1.attr("value", category)
			form.append(input1)
			form.appendTo("body")
			form.css('display', 'none')
			form.submit()
		}
	</script>
</body>
</html>