<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main.css" />
<title>Food Display</title>
<style type="text/css">body {margin-bottom:300px;}</style>
</head>
<body>
	<div class="main">
		<div class="main-content">
			<div class="container-fluid">
				<h3 class="page-title">菜品管理</h3>
				<div class="row">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">菜品</h3>
							
						</div>
						
						<br />
						<form action="admin/food/foodAdd.jsp">
							<input type="submit" value="添加菜品">
						</form>
						<br/>
                        <br/>
						<form action="${pageContext.request.contextPath}/SearchFood" method="post">
							<div align="center">
								&nbsp; <label> </label> <label> 输入菜品名称: <input
									type='text' name='info' value='' />
								</label> <label> &nbsp; <input type="submit" type="button"
									value="查询" />
								</label>
								<br/>
							</div>
						</form>
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
								</thead>
								<tbody>
								<c:forEach var="food" items="${requestScope.foodList}">
									<tr>
										<td>${food.foodID}</td>

										<td>${food.name}</td>
										<td>${food.subName}</td>

										<td><img src="${pageContext.request.contextPath}/foodImage/${food.imagePath}" width=200px height=200px></td>

										<td>￥${food.price}</td>

										<td>${food.description}</td>

										<td>

											<form style="align: center; background-color: gray"
												action="${pageContext.request.contextPath}/JumpToEditePage?id=${food.foodID}"
												method="post">

												<input type="hidden" name="food"
													value="${food.foodID}"> <input type="submit"
													value="修改">
											</form>

										</td>
										<form action="${pageContext.request.contextPath}/DeleteFood.do">
											<td><a
												href="${pageContext.request.contextPath}/DeleteFood?id=${food.foodID}">删除</a>
											</td>
										</form>
										<form action="${pageContext.request.contextPath}/JumpToEditeCategoryPage?id=${food.foodID}" method="post">
											<td>
											<input type="hidden" name="food"
													value="${food.foodID}"> <input type="submit"
													value="编辑类别">
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