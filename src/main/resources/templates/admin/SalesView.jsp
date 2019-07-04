<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<!DOCTYPE html>
<html style="background-color: #fff">
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
<title>Insert title here</title>
</head>
<body>
	
	<div class="main">
		<div class="main-content">
			<div class="container-fluid">
				<h3 class="page-title">销售情况查询</h3>
				<div class="row">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">销售情况</h3>
						</div>

						<div class="panel-body">
							<table align="center">
								<tr>
									<td width="150px">查询范围</td>
									<td width="350px">
										<form method="POST" name="SearchSales"
											action="${pageContext.request.contextPath}/SalesView.do">
											<mytag:SalesViewSelect />
											<input type="submit" value="Search">
										</form>
									<th>${selectrange}的销售情况</th>
									</td>
								</tr>
							</table>

							<table class="table">
								<thead>
									<tr>
										<th>菜品ID</th>
										<th>菜品名</th>
										<th>销售数量</th>
									</tr>
								</thead>
								<c:forEach var="sale" items="${sales}">
									<tbody>
										<tr>
											<td>${sale.foodId}</td>
											<td>${sale.foodName}</td>
											<td>${sale.amount}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>