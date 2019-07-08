<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css"/>
<title>查询结果</title>
</head>
<body>
<div class="main">
	<div class="main-content">
		<div class="container-fluid">
			<h3 class="page-title">菜品管理</h3>
			<div class="row">
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title">查询结果</h3>
					</div>
					<div class="panel-body">
						<table class="table">
							<thead>
									<tr>
										<th>ID</th>
										<th>菜名</th>
										<th>菜品子名字</th>
										<th>图片展示</th>
										<th>价格</th>
										<th>描述</th>
										<th></th>
										<th></th>
									</tr>
							<tbody>
								<c:forEach var="food" items="${requestScope.foods}">
				<tr>
					<td>${food.foodID}</td>
					<td>${food.name}</td>
					<td>${food.subName}</td>
					<td><img src="${pageContext.request.contextPath }/foodImage/${food.imagePath}" width=200px height=200px></td>
					<td>￥${food.price}</td>
					<td>${food.description}</td>
				</tr>
			</c:forEach>
							
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>