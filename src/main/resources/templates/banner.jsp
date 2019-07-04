<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="LYHTags" prefix="loginT"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<script>
	function openLogin() {
		document.getElementById("login").style.display = "";
	}
	function closeLogin() {
		document.getElementById("login").style.display = "none";
	}

	function Login() {
		if ($("#username").val() == "") {
			alert('用户名不能为空!');
			return;
		}
		if ($("#userpwd").val() == "") {
			alert('密码不能为空!');
			return;
		}
		document.f.submit();

	}
</script>
<style type="text/css">
.input_control {
	/*-web-kit-appearance:none;*/
	-moz-appearance: none;
	font-size: 1em;
	height: 2.7em;
	border-radius: 4px;
	/* 	border:1px solid #c8cccf; */
	color: #6a6f77;
}
</style>

<body>
	<div id="header">
		<div class="content">
			<a href="pcHomepage.jsp" id="logo"><img
				src="${pageContext.request.contextPath}/templets/cloud_04/images/logo.png"
				height="40" /></a>
			<ul id="nav">
				<li class="navitem"><a
					href="${pageContext.request.contextPath}/pcHomepage.jsp"
					target="_self">首页</a></li>
				<li class="navitem"><a href="javascript:void(0);"
					onclick="categoryClicked('全部');">菜品 </a></li>
				<c:if test="${sessionScope.type=='customer'}">
					<li class="navitem"><a
						href="${pageContext.request.contextPath}/GetOrders" target="_self">订单</a></li>
					<li class="navitem"><a
						href="${pageContext.request.contextPath}/ShoppingCart"
						target="_self">购物车</a></li>
				</c:if>

				<loginT:login />
			</ul>
			<div id="login" style="display: none;" class="input_control">
				<form name="f" action="${pageContext.request.contextPath}/login"
					method="POST">
					<span style="font-size: 1em; margin-bottom: 10px; color: white;">欢迎登陆网上订餐系统</span><br />
					<label style="color: white;">用户名：</label><input type="text"
						style="border: white 1px solid; color: white; border-radius: 3px;"
						name="username" id="username" value="${cookie.username.value}"
						onclick="JavaScript:this.value=''" /> <label
						style="color: white; margin-left: 5px">密码：</label><input
						style="border: white 1px solid; color: white; border-radius: 3px;"
						name="password" id="password" type="password"
						onclick="JavaScript:this.value=''" /> <input type="button"
						value="登 陆"
						style="border-radius: 3px; color: white; margin-left: 10px; cursor: pointer; border: white 0.6px solid; padding: 2px 6px; font-size: 10px;"
						onclick="Login();" /> <input type="button" value="取 消"
						style="color: white; cursor: pointer; border: white 0.6px solid; padding: 2px 6px; margin-left: 10px; font-size: 10px; border-radius: 3px;"
						onclick="closeLogin();" />
				</form>
			</div>

			<div class="clear"></div>
		</div>
		<a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a>
	</div>
	<script type="text/javascript">
		function categoryClicked(category) {
			form = $("<form></form>")
			form.attr('action', '${pageContext.request.contextPath}/GetFoods')
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