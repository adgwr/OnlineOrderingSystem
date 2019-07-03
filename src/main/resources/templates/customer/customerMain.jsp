<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="LYHTags" prefix="LYH" %>
<!DOCTYPE html>
<html style="background-color:#212121">
<head>
<script type="text/javascript">
	try {
		if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			window.location.href = "m/perInfo.jsp";
		}
	} catch (e) {
	}
</script>
<style>
#title{
	margin-top:30px;
	margin-bottom:10px;
	text-align: center;
	font-family: "Times New Roman", "微软雅黑";
	color: #fff;
	font-size: 26px;
}
#subtitle{
		text-align: center;
	    font-size: 14px;
	    color: #B4B4B4;
	    font-family: "Times New Roman", "微软雅黑";
	    margin-bottom:25px;
}
table {
	border: 3px solid #606060;
	color: #fff;
	background-color: transparent;
	width: 90%;
	border-collapse: collapse;
	margin: auto;
	border-radius: 5px;
}
table tr th{
	border: 2px solid #606060;
	font-size: 20px;
	padding: 10px;
	font-family: "Times New Roman", "微软雅黑";
}
table tr td {
	border: 2px solid #606060;
	font-size: 15px;
	text-align:center;
	font-family: "Times New Roman", "微软雅黑"; 
}
</style>
<title>Insert title here</title>
</head>
<body>
	<p id="title">用户信息</p>
	<p id="subtitle">USER INFORMATION</p>
	<table>
			<tr>
				<th>用户名</th>
				<td>${user.c_id }</td>
			</tr>
			<tr>
				<th>电话</th>
				<td>${user.c_tel}</td>
			</tr>
			<tr>
				<th>电子邮箱</th>
				<td>${user.email}</a></td>
				<%-- <td><a href="${pageContext.request.contextPath}/customer/editCustomer.jsp">编辑</a></td> --%>
			</tr>
	</table>
</body>
</html>