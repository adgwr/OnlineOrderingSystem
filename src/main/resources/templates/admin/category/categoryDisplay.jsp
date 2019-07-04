<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!--<%@page import="sun.awt.SunHints.Value"%>-->
<%@page import="java.util.List"%>
<%@page import="entity.Category"%>
<%@page import="model.CategoryExpert"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
<title>Category Display</title>
</head>
<body>
	<div class="main">
		<div class="main-content">
			<div class="container-fluid">
				<h3 class="page-title">菜品类别管理</h3>
				<div class="row">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">菜品类别</h3>
							<br />
							<form action="admin/category/categoryAdd.jsp" accept-charset="UTF-8" onsubmit="document.charset='UTF-8';">
								<input type="submit" value="添加菜品类别">
							</form>
							<br /> <br />
						</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<td><b>ID</b></td>
										<td><b>类别名</b></td>
										<td><b>修改</b></td>
										<td><b>删除</b></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="category" items="${requestScope.categorys}">
										<tr>
											<td>${category.categoryID}</td>

											<td>${category.name}</td>

											<td>

												<form style="align: center; background-color: gray"
													action="${pageContext.request.contextPath}/EditeCategory.do"
													method="post" onsubmit="return check(this);">

													<input type="hidden" name="id"
														value="${category.categoryID}"> <input
														type="text" name="categoryName" size="15"> <input
														type="submit" value="修改类名">
												</form>
											</td>
											<form
												action="${pageContext.request.contextPath}/DeleteCategory.do">
												<td><a
													href="${pageContext.request.contextPath}/DeleteCategory?id=${category.categoryID}">删除</a>
												</td>
											</form>
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