<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main.css" />
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
							<h3 class="panel-title">选择类别</h3>
							<h4>ID:${requestScope.foodId }</h4>
							<h4>菜名:${requestScope.foodName }</h4>
						</div>
						<div class="panel-body">

							<form action="${pageContext.request.contextPath}/EditeFoodCategory" method="post">
								<table class="table">
									<c:forEach var="category" items="${requestScope.categorys}">
										<tr>
											<td width="69">
											<input type="checkbox" name="item" value="${category.categoryID}"></td>
											<td width="431">${category.name}</td>
										</tr>
									</c:forEach>

									<input type="hidden" name="foodId"
										value="${requestScope.foodId}">
									<input type="submit" value="提交">

									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>